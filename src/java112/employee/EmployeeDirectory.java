package java112.employee;

import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * This represents a directory of employees for a company. It is intended
 * to be placed within the ServletContext, where the app can then maintain it.
 *
 * @author jcmann
 */
public class EmployeeDirectory {

    /**
     * Represents the project4.properties file.
     */
    private Properties properties;

    /**
     * Empty no-arg constructor.
     */
    public EmployeeDirectory() {

    }

    /**
     * Initializes an instance and sets the properties instance variable,
     * which is required to run successfully.
     *
     * @param properties properties object to assign to instance variable
     */
    public EmployeeDirectory(Properties properties) {
        this.properties = properties;
    }

    /**
     * Establishes a connection to the database being used.
     *
     * @return the connection representing the database being used
     * @throws SQLException because this is connecting to a database
     * @throws ClassNotFoundException because of its driver name 
     */
    private Connection connectToDatabase() throws SQLException, ClassNotFoundException {

        // load driver
        Class.forName(this.properties.getProperty("driver"));

        Connection connection = DriverManager.getConnection(
                this.properties.getProperty("url"), 
                this.properties.getProperty("username"), 
                this.properties.getProperty("password"));
    
        return connection;
    }

    /**
     * This public method starts the process of adding a new employee
     * to the employee database. It relies on helper methods for the
     * specific tasks involved.
     *
     * @param firstName the new employee's first name
     * @param lastName the new employee's last name
     * @param ssn the new employee's social security number, as an int
     * @param department the new employee's department name
     * @param roomNumber the new employee's room number (letters/numbers ok)
     * @param phoneNumber the new employee's phone number (special chars ok)
     * @return an int representing the number of rows affected, success indicator
     *      should be 1!
     */
    public int addNewEmployee(String firstName, String lastName,
            int ssn, String department, String roomNumber, String phoneNumber) {

        // Get a connection to the database
        Connection connection = null;
        PreparedStatement preparedStatement = null; 
        int rowsAffected = 0; 

        // Generate the SQL statement for the INSERT
        String query = "INSERT INTO employees (first_name, last_name, ssn, "
                + "dept, room, phone) VALUES (" 
                + "?, ?, ?, ?, ?, ?);";

        try {
            // Initialize connection/statement
            connection = connectToDatabase(); 
            preparedStatement = connection.prepareStatement(query); 

            // Set the values 
            preparedStatement.setString(1, firstName); 
            preparedStatement.setString(2, lastName); 
            preparedStatement.setInt(3, ssn); 
            preparedStatement.setString(4, department); 
            preparedStatement.setString(5, roomNumber); 
            preparedStatement.setString(6, phoneNumber); 

            rowsAffected = preparedStatement.executeUpdate(); 

        } catch (SQLException exc) {
            System.out.println("There was a SQL error."); 
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("Something went wrong :("); 
            exc.printStackTrace();
        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close(); 
                }

            } catch (Exception exc) {
                System.out.println("Something went wrong closing JDBC code."); 
                exc.printStackTrace();
            }  

            return rowsAffected; 

        }

    }

    /**
     * This method starts the process of searching the database for employees
     * that match certain criteria. It relies on helper methods to do so,
     * but some shared code lives in this method.
     *
     * @param searchTerm the term being searched for (id, name, etc.)
     * @param searchType what kind of search is being performed (id, name, etc.)
     * @return a Search object representing the search results and details
     */
    public Search search(String searchTerm, String searchType) {

        // Prep the Search object we work with
        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);

        // Prepping for try/catch block without resources
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet results = null;

        try {

            // Create connection (shared task, pass into methods)
            connection = connectToDatabase();

            // Call searchBy___ method to generate the correct PreparedStatement
            switch (searchType) {
                case "id":
                    preparedStatement = searchByID(connection, search);
                    break;
                case "firstName":
                    preparedStatement = searchByFirstName(connection, search);
                    break;
                case "lastName":
                    preparedStatement = searchByLastName(connection, search);
                    break;
            }

            // Run the query
            results = preparedStatement.executeQuery();

            // Create an Employee for each result found,
            // using results data to set its instance variables
            while (results.next()) {

                if (!search.isEmployeesFound()) {
                    search.setEmployeesFound(true); 
                }

                Employee employee = new Employee();

                // Extract data from results and assign to IVs
                employee.setId(results.getInt("emp_id"));
                employee.setFirstName(results.getString("first_name"));
                employee.setLastName(results.getString("last_name"));
                employee.setSsn(Integer.parseInt(results.getString("ssn")));
                employee.setDepartment(results.getString("dept"));
                employee.setRoomNumber(results.getString("room"));
                employee.setPhoneNumber(results.getString("phone"));

                // Add each employee  with addFoundEmployee()
                search.addFoundEmployee(employee);

            }

        } catch (ClassNotFoundException exc) {
            System.out.println("Class was not found.");
            exc.printStackTrace();
        } catch (NullPointerException exc) {
            System.out.println("NullPointerException occurred.");
            exc.printStackTrace();
        } catch (SQLException exc) {
            System.out.println("There was an issue with SQL.");
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("Something went wrong!");
            exc.printStackTrace();
        } finally {

            try {

                if (results != null ) {
                    results.close(); 
                }
                
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close(); 
                }
            } catch (Exception exc) {
                System.out.println("Something went wrong."); 
                exc.printStackTrace();
            }
            return search; 
        }


    }

    /**
     * A helper method for the search method that facilitates searching
     * the database by the employee ID.
     *
     * @param search the search object being worked on
     * @param connection the connection created in search
     * @throws SQLException caused by JDBC function of creating a prepared statement
     * @return PreparedStatement with the appropriate query set
     */
    private PreparedStatement searchByID(Connection connection, Search search)
            throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from employees where emp_id = ?"
        );

        // Considering I think this might end up wrapping it back to String,
        // is the parseInt redundant?
        preparedStatement.setInt(1, Integer.parseInt(search.getSearchTerm()));

        return preparedStatement;
    }

    /**
     * This helper method facilitates searching the database by first name, 
     * and exists solely to generate a prepared statement in order to do so. 
     * 
     * @param connection the database connection being used 
     * @param search the search object representing this search data
     * @return a preparedstatement with appropriate query set
     * @throws SQLException caused by JDBC function of creating a prepared statement
     */
    private PreparedStatement searchByFirstName(Connection connection, Search search)
            throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from employees where first_name = ?"
        );

        preparedStatement.setString(1, search.getSearchTerm());

        return preparedStatement;
    }

    /**
     * This helper method facilitates searching the database by last name, 
     * and exists solely to generate a prepared statement in order to do so. 
     * 
     * @param connection the database connection being used 
     * @param search the search object representing this search data
     * @return a preparedstatement with appropriate query set
     * @throws SQLException caused by JDBC function of creating a prepared statement
     */
    private PreparedStatement searchByLastName(Connection connection, Search search)
            throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT *  from employees where last_name = ?"
        );

        preparedStatement.setString(1, search.getSearchTerm());

        return preparedStatement;
    }
    
}

package java112.project4;

import java.io.*;
import java.sql.*;

/**
 * Uses a prepared statement to insert employee data, provided via 
 * command line args. 
 * 
 * @author jcmann
 */
public class JDBCPreparedStatement {

    /**
     * Collects data from employeeInfo and inserts into a prepared statement, 
     * which is then used to insert the data into the table. 
     *  
     * @param employeeInfo previously args
     */
    public void run(String[] employeeInfo) {

        ResultSet results = null; // not used here, but just in case!

        try (
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/student?serverTimezone=UTC", "student", "student");
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                        "INSERT INTO employees (first_name, last_name, "
                        + "ssn, dept, room, phone) VALUES(?, ?, ?, ?, ?, ?);"
                        , Statement.RETURN_GENERATED_KEYS
                    ); 
        ) {
            // Load the driver 
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Collect input from args
            String firstName = employeeInfo[0]; 
            String lastName = employeeInfo[1]; 
            String ssn = employeeInfo[2]; 
            String dept = employeeInfo[3]; 
            String room = employeeInfo[4];
            String phone = employeeInfo[5]; 

            // set params of prepared statement
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName); 
            preparedStatement.setString(3, ssn); 
            preparedStatement.setString(4, dept); 
            preparedStatement.setString(5, room); 
            preparedStatement.setString(6, phone);  

            // execute update, because insert statement
            preparedStatement.executeUpdate(); 
            
            results = preparedStatement.getGeneratedKeys(); 
            if (results.next()) {
                int id = results.getInt(1); 
                outputInserted(id, connection); 
            }

            
        } catch (SQLException exc) {
            System.out.println("There was a SQL error.");
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            System.out.println("Class was not found."); 
            exc.printStackTrace();
        }

    }

    /**
     * Helper method for the run method. This prints out the data 
     * entered in the previous statement out to the console by creating
     * a query to do so. 
     * 
     * @param id the id of the most recently inserted record 
     * @param connection the connection to the database established
     * @throws SQLException handled in the run method 
     */
    public void outputInserted(int id, Connection connection) throws SQLException {
        // Create the query 
        Statement statement = connection.createStatement(); 
        String query = "SELECT * FROM employees WHERE emp_id = " + id + ";";
        
        ResultSet results = statement.executeQuery(query); 

        System.out.println("Data: ");

        while (results.next()) {
            String employeeId = results.getString("emp_id");
            String firstName = results.getString("first_name");
            String lastName = results.getString("last_name");
            String ssn = results.getString("ssn");
            String dept = results.getString("dept"); 
            String room = results.getString("room"); 
            String phone = results.getString("phone"); 
            System.out.println(" ID: " + employeeId + ". Name: "
                        + firstName + " " + lastName + ". SSN: " + ssn
                        + ". Dept and Room: " + dept + " " + room
                        + ". Phone: " + phone);
        }
    }

    /**
     * Main method for the class. Creates an instance of this class, and 
     * calls its run method to use a prepared statement to insert data. 
     * 
     * @param args command line args, used for employee data 
     */
    public static void main(String[] args) {

        if (args.length != 6) {
            System.out.println("Please enter six arguments of employee information."); 
            for (String a : args) {
                System.out.println(a);
            }
        } else {
            JDBCPreparedStatement employee = new JDBCPreparedStatement();
  
            employee.run(args);
        }
        
    }
    
}

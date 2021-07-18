package java112.project4;
  
import java.io.*;
import java.sql.*;

/**
 * Inserts employees into the Employees table of the database.
 * 
 * @author jcmann
 */
public class JDBCInsertEmployee {

    /**
     * Uses command line args (employeeInfo) to run an insert statement, 
     * inserting employee info into the employees table. 
     * 
     * @param employeeInfo previously args, employee information 
     */
    public void run(String[] employeeInfo) {

        ResultSet resultSet = null;

        try (
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/student?serverTimezone=UTC", "student", "student");
            Statement statement = connection.createStatement(); 
            
        ) {
            // Load the driver 
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Collect data from args
            String firstName = employeeInfo[0]; 
            String lastName = employeeInfo[1]; 
            String ssn = employeeInfo[2]; 
            String dept = employeeInfo[3]; 
            String room = employeeInfo[4];
            String phone = employeeInfo[5]; 

            // Build query 
            String query = "INSERT INTO employees (first_name, last_name, "
                    + "ssn, dept, room, phone) VALUES ('" 
                    + firstName + "', '" + lastName + "', '" + ssn + "', '"
                    + dept + "', '" + room + "', '" + phone + "');"; 

            // Execute query
            System.out.println("Query: " + query); 
            int rowsAffected = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = statement.getGeneratedKeys(); 
            if (rs.next()) {
                int id = rs.getInt(1); 
                // System.out.println("ID: " + id); 
                outputInserted(id, connection); 
            }
            rs.close();

            // This means the employee was successfully inserted 
            if (rowsAffected > 0) {

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
     * Helper method for this lab. Outputs the most recent query row. 
     * Does not return anything, just prints to the console.
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
     * Main method for the class. Instantiates a new instance of this class, 
     * and then calls its run method to insert a new employee to the table. 
     * 
     * @param args command line args
     */
    public static void main(String[] args) {

        if (args.length != 6) {
            System.out.println("Please enter six arguments of employee information."); 
            for (String a : args) {
                System.out.println(a);
            }
        } else {
            JDBCInsertEmployee employee = new JDBCInsertEmployee();
  
            employee.run(args);
        }
  
        
  
    }
    
}

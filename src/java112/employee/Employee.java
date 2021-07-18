package java112.employee; 

/**
 * This class represents an individual employee. 
 * 
 * @author jcmann
 */
public class Employee {

    /**
     * The Employee ID, an int. 
     */
    private int id; 

    /**
     * The employee's first name, a String. 
     */
    private String firstName = "first name"; 

    /**
     * The employee's last name, a String.
     */
    private String lastName; 

    /**
     * The employee's social security number, an int (no dashes)
     */
    private int ssn; 

    /**
     * The employee's department name, a String.
     */
    private String department; 

    /**
     * The employee's office room number, a String. 
     */
    private String roomNumber; 

    /**
     * The employee's phone number. 
     */
    private String phoneNumber; 

    /**
     * Empty, no-arg constructor. 
     */
    public Employee() {

    } 

    /**
     * Constructor with all instance variables set with the params. 
     * 
     * @param id the provided ID to be assigned 
     * @param firstName the provided first name to be assigned
     * @param lastName the provided last name to be assigned
     * @param ssn the provided social security number to be assigned
     * @param department the provided department name to be assigned
     * @param roomNumber the provided room number to be assigned
     * @param phoneNumber the provided phone number to be assigned
     */
    public Employee(int id, String firstName, String lastName, int ssn, 
            String department, String roomNumber, String phoneNumber) {

    }

    
    /** 
     * Overrides the toString method to display the instance variables. 
     * 
     * @return String representing the employee and their complete data. 
     */
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", ssn='" + getSsn() + "'" +
            ", department='" + getDepartment() + "'" +
            ", roomNumber='" + getRoomNumber() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            "}";
    }


    
    /** 
     * Getter method for the id instance variable, an int. 
     * 
     * @return int, the employee ID instance variable
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * Setter method for the id instance variable.
     * 
     * @param id the new id to be assigned to the instance variable
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * Getter method for the firstName instance variable, a String. 
     * 
     * @return the firstName instance variable, a String
     */
    public String getFirstName() {
        return this.firstName;
    }

    
    /** 
     * Setter method for the firstName instance variable.
     * 
     * @param firstName the new String to be assigned to the instance variable
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    /** 
     * Getter method for the lastName instance variable, a String. 
     * 
     * @return the firstName instance variable, a String
     */
    public String getLastName() {
        return this.lastName;
    }

    
    /** 
     * Setter method for the lastName instance variable.
     * 
     * @param lastName the new String to be assigned to the instance variable
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    /** 
     * Getter method for the ssn instance variable, representing the 
     * employee's social security number.
     * 
     * @return the employee's social security number as an int, no special chars
     */
    public int getSsn() {
        return this.ssn;
    }

    
    /** 
     * Setter method for the ssn instance variable, representing the 
     * employee's social security number (no special characters)
     * 
     * @param ssn the new int to be assigned to the instance variable
     */
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    
    /** 
     * Getter method for the department instance variable, a String. 
     * 
     * @return the department name instance variable, a String
     */
    public String getDepartment() {
        return this.department;
    }

    
    /** 
     * Setter method for the department instance variable.
     * 
     * @param department the new String to be assigned to the instance variable
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    
    /** 
     * Getter method for the roomNumber instance variable, a String. 
     * 
     * @return the roomNumber instance variable, a String (may beletters and nums)
     */ 
    public String getRoomNumber() {
        return this.roomNumber;
    }

    
    /** 
     * Setter method for the roomNumber instance variable. Letters and 
     * numbers are allowed. 
     * 
     * @param roomNumber the new String to be assigned to the instance variable
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    
    /** 
     * Getter method for the phoneNumber instance variable, a String. 
     * 
     * @return the phoneNumber instance variable, a String. May contain
     *      special characters.
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    
    /** 
     * Setter method for the phoneNumber instance variable, special characters
     * are allowed.
     * 
     * @param phoneNumber the new String to be assigned to the instance variable
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}

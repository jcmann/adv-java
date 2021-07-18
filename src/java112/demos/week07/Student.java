package java112.demos.week07;

/**
 * This class is used in a demo of the TreeMap class.
 * @author Eric Knapp
 */
public class Student {

    private String studentId;
    private String firstName;
    private String lastName;
    private double gradePointAverage;

    /**
     * Constructor for Student.
     */
    public Student() {
        studentId = "Unknown ID";
        firstName = "Unknown";
        lastName = "Unknown";
        gradePointAverage = 4.0;
    }

    /**
     * Basic constructor for Student.
     *
     * @param studentId the Student ID
     * @param firstName the Student's first name
     * @param lastName the Student's last name
     * @param gradePointAverage the Student's grade point average
     */
    public Student(String studentId, String firstName, String lastName, double gradePointAverage) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradePointAverage = gradePointAverage;
    }

    /**
     * Adjust the grade point average of the student by the incremental amount.
     * @param incremental the amount to add to the grade point average
     */
    public void adjustGradePointAverage(double incremental) {
        gradePointAverage += incremental;
    }

    /**
     * A text representation of the Student for debugging.
     * @return the student string
     */
    public String toString() {
        String student = "Student: studentId=" + studentId
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", gradePointAverage=" + gradePointAverage;

        return student;
    }

}

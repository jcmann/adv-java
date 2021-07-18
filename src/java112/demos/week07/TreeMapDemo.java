package java112.demos.week07;

import java.util.*;

/**
 *  This class demonstrates the use of the TreeMap class. <br>
 *
 *
 *@author     eknapp
 */
class TreeMapDemo {

    /**
     * Run this demo.
     */
    private void run() {
        /**
         *  Create an instance of the TreeMap class. This class holds a sorted set
         *  of mapped data. The key can be any object, including a String. The value
         *  can be any object, including a custom class that you would write.
         *
         *  You can declare this variable as type Map or TreeMap like this:
         *
         *  Map students = new TreeMap();
         *  OR
         *  TreeMap students = new TreeMap();
         *
         *  Try it! They will both compile and run.
         *
         *  What are creating here is a collection of students. We will use a
         *  Student class.
         */
        Map<String, Student> students = new TreeMap<String, Student>();

        /**
         *  Now we will add a group of Student objects to the TreeMap
         */
        students.put("a1234", new Student("a1234", "Fred", "Jones", 2.5));
        students.put("b3452", new Student("b3452", "Sally", "Smith", 3.0));
        students.put("f9874", new Student("f9874", "Bill", "Crandall", 3.5));
        students.put("r2234", new Student("r2234", "June", "White", 3.8));
        students.put("c4321", new Student("c4321", "John", "Green", 4.0));
        students.put("u9877", new Student("u9877", "Jill", "Black", 3.2));
        students.put("w3458", new Student("w3458", "Jim", "Brown", 2.0));

        // Now we will output the collections

        displayStudents(students);

        /**
         *  Now we will add 0.2 to Jill's grade point. Notice that we don't have
         *  to put the 'student' back into the TreeMap, it is still there and we are
         *  changing it in place.
         */
        Student student = (Student) students.get("u9877");
        student.adjustGradePointAverage(0.2);

        // And then display the students again to confirm the salary increase

        displayStudents(students);
    }

    /**
     *  This method outputs the students to the standard output
     *
     *@param  students  The employee TreeMap to be displayed
     */
    private void displayStudents(Map<String, Student> students) {

        System.out.println();
        System.out.println("Student List:");

        for (Map.Entry<String, Student> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();
    }

    /**
     * The main method for the demo.
     *
     *@param  arguments  Parameters that are entered on the command line.
     */
    public static void main(String[] arguments) {

        TreeMapDemo demo = new TreeMapDemo();
        demo.run();
    }
}

public class Student {
    String name;
    String studentNumber;

    Student(){ //constructor
        name = "";
        studentNumber = "";
    }

    //Override toString() method to print according to instructions
    @Override
    public String toString() {
        return "Name:  " + name + "\n" +
                "Student Number:  " + studentNumber;
    }
}

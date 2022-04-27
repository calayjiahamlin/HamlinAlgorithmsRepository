public class Student {
    String name;
    String studentNumber;

    Student(){
        name = "";
        studentNumber = "";
    }

    //Override
    @Override
    public String toString() {
        return "Name:  " + name + "\n" +
                "Student Number:  " + studentNumber;
    }
}

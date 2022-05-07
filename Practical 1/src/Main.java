public class Main {

    public static void main(final String[] args) {
        //create two student objects
        Student s1 = new Student();
        Student s2 = new Student();

        //assign name and student numbers to both students
        s1.name = "Dion";
        s1.studentNumber = "1";

        s2.name = "Esperanza";
        s2.studentNumber = "2";

        //print the overridden toString method of each student
        System.out.println(s1.toString());
        System.out.println(s2.toString());

        System.exit(0);
    }
}

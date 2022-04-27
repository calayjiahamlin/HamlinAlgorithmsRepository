public class Main {

    public static void main(final String[] args) {
        // Your code goes here!
        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "Dion";
        s1.studentNumber = "1";

        s2.name = "Esperanza";
        s2.studentNumber = "2";

        System.out.println(s1.toString());
        System.out.println(s2.toString());

        System.exit(0);
    }
}

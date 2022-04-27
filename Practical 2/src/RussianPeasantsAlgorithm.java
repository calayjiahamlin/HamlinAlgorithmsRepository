import java.util.Scanner;

public class RussianPeasantsAlgorithm {

    public static int russianPeasantMult(final int x, final int y) {
        int total = 0;
        int left = x;
        int right = y;

        while (left != 0) {
            if (left % 2 != 0) {
                total = total + right;
            }
            left = left / 2;
            right = right * 2;
        }
        return total;
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int numb1 = scan.nextInt(); //Integer.parseInt(args[0]);

        System.out.print("Enter the second number: ");
        int numb2 = scan.nextInt(); //Integer.parseInt(args[1]);

        scan.close();

        long startTime = System.nanoTime();
        System.out.println("Terms multiplied equal: " + russianPeasantMult(numb1, numb2));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

        System.out.println(duration + " " +"in nanoseconds");
        System.out.println((duration/1000000) + " " + "in milliseconds");
    }
}


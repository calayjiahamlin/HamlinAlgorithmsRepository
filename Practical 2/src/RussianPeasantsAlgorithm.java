import java.util.Scanner;

public class RussianPeasantsAlgorithm {

    /**
     * Russian Peasant's Algorithm is an algorithm for multiplication
     * that uses doubling, halving, and addition
     * @param x: multiplicand
     * @param y: multiplier
     * @return returns product of the integers x and y
     */
    public static int russianPeasantMult(final int x, final int y) {
        int total = 0;
        int left = x;
        int right = y;

        while (left != 0) {
            if (left % 2 != 0) {
                total = total + right; //add multiplier to total if when
            }                          //multiplicand divided by 2 is odd
            left = left / 2; // divide the multiplicand by 2
            right = right * 2; // multiply the multiplier by 2
        }
        return total; // return the total
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in); // open scanner for input
        System.out.print("Enter the first number: ");
        int numb1 = scan.nextInt(); //store input;

        System.out.print("Enter the second number: "); // get next number
        int numb2 = scan.nextInt(); //store input

        scan.close(); //close input scanner

        long startTime = System.nanoTime(); //begin timer
        System.out.println("Terms multiplied equal: " + russianPeasantMult(numb1, numb2)); //use input and run RPM
        long endTime = System.nanoTime(); //stop timer

        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

        System.out.println(duration + " " +"in nanoseconds"); //print duration in nanoseconds
        System.out.println((duration/1000000) + " " + "in milliseconds"); //print duration in milliseconds
    }
}


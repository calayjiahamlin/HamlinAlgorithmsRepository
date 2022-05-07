

public class DynamicProgramming {

    /**
     * Simple recursive implementation for calculating fibonacci series
     * @param n: integer up to which the fibonacci series is calculated
     * @return the answer to the fibonacci series calculation
     *
     * Time complexity: O(2^n) due to the redundancy of sub-problems being calculated unnecessarily
     * Auxiliary space complexity: in-place; no outside, temporary storage is used to complete calculation
     */
    public static int fib(final int n){
        if (n < 2) {
            return n; // return 0 or 1
        }
        return fib(n-1) + fib(n-2); // recursively add together the answer of two sub-problems
    }

    /**
     * Improved iterative implementation of recursive fibonacci function to include dynamic programming
     * @param n: integer up to which the fibonacci series is calculated
     * @return the answer to the fibonacci series calculation
     *
     * Time complexity: O(N) mainly due to the number of for loop passes being based on the n input meanwhile
     *                  setting aside the constant time computations
     * Auxiliary space complexity: out-of-place; temporary storage is used to complete calculation
     *                             specifically, the array used to calculate the fibonacci series
     */
    public static int fibDp(final int n){
        int[] F = new int[n]; //initialize integer array to hold calculations
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i < n; i++) { //iterate through sequence up to and include n
            F[i] = F[i - 1] + F[i - 2]; //store sum of two previous values
        }
        return F[n - 1]; //return the last position of the array
    }

    /**
     * Longest Common String implementation to include dynamic programming
     * @param sOne: first input string to be compared
     * @param sTwo: second input string to be compared
     * @return number of the longest common string between the two input strings
     *
     * Time complexity: O(N^2) mainly due to the number of passes in the nested for loop being based on the lengths of
     *                  strings being compared to find the LCS
     * Auxiliary space complexity: out-of-place; temporary storage is used to complete calculation
     *                             specifically, the table used to determine the maximum value
     */
    public static int LCS(final String sOne, final String sTwo){
        int one = sOne.length(); //assigned the lengths of the two strings
        int two = sTwo.length();

        int[][] LCS = new int[one + 1][two + 2]; //create table to store and determine LCS
        for(int i = 0; i < one; i++){
            for(int j = 0; j < two; j++){
                if(sOne.charAt(i) == sTwo.charAt(j)){ // if match found,
                    LCS[i + 1][j + 1] = LCS[i][j] + 1; // store sum of previous in table and one
                }
                else{ //if no match, store maximum between previous of row and column positions, respectively
                    LCS[i + 1][j + 1] = Math.max(LCS[i][j + 1], LCS[i + 1][j]);
                }
            }
        }
        return 0;
    }

    /**
     * Knapsack brute force implementation with 0-1 property; no splitting
     * @param W: denotes capacity weight allowed
     * @param w: array of weights corresponding to n items
     * @param vals: array of values corresponding to n items
     * @return the maximum value subset of vals[] such that sum of the weights of this
     *         subset is smaller than or equal to W
     *
     * Time complexity: O(2^n) due to the redundancy of sub-problems being calculated unnecessarily
     * Auxiliary space complexity: in-place; no outside, temporary storage is used to complete calculation
     */
    public static int knapsackBf(final int W, final int[] w, final int[] vals){
        int n = 0;
        return knapsackBf(W, w, vals, n);
    }

    public static int knapsackBf(final int W, final int[] w, final int[] vals, int n){

        int result;
        if(n == 0 || W == 0){
            result = 0;
        }
        else if(w[n - 1] > W){
            result = knapsackBf(W, w, vals,n-1);
        }
        else {
            int prev1 = knapsackBf(W, w, vals,n-1);
            int prev2 = vals[n-1] + knapsackBf(W - w[n-1], w, vals,n-1);
            result = Math.max(prev1,prev2);
        }
        return result;
    }

    /**
     * Knapsack dynamic programming implementation with 0-1 property; no splitting
     * @param W: denotes capacity weight allowed
     * @param w: array of weights corresponding to n items
     * @param vals: array of values corresponding to n items
     * @return the maximum value subset of vals[] such that sum of the weights of this
     *         subset is smaller than or equal to W
     * Time complexity: O(N * W) mainly due to the function's dependency on the number of items and capacity weight
     *                           on the number of passes in the nested for loop
     * Auxiliary space complexity: out-of-place; temporary storage is used to complete calculation
     *                             specifically, the table (2-D array) used to determine the maximum value
     */
    public static int knapsackDp(final int W, final int[] w, final int[] vals){
        int n = 0;
        return knapsackDp(W, w, vals, n);
    }

    public static int knapsackDp(final int W, final int[] w, final int[] vals, int n){

        int[][] KS = new int[n + 1][W + 2]; //create table to store and determine the highest value at the capacity weight
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= W; j++){
                if(i == 0 || j == 0){
                    KS[i][j] = 0;
                }
                else if (w[i - 1] <= j) {
                    int prev1 = KS[i - 1][j];
                    int prev2 = vals[i-1] + KS[i - 1][j - w[i - 1]];
                    KS[i][j] = Math.max(prev1, prev2);
                }
                else{
                    KS[i][j] = KS[i - 1][j];
                }
            }
        }
        return KS[n][W];
    }
}

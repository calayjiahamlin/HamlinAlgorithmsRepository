# Hamlin Algorithms Repository
COMP20290 tutorial/practical assignments

## Practical 2 - Russian Peasant's Algorithm
Brief Description: an algorithm for multiplication that uses doubling, halving, and
addition. This was an algorithm or a tool that was used before computers by people to multiply
two numbers.

#### Complexity Information

Performance Implications: N/A

Time Complexity: O(1) because the time taken to perform the algorithm has an upper bound that will never 
                 be exceeded no matter the size of the inputs

Auxiliary Space Complexity: in-place; there is no outside structure of significance in addition to the input being used
                            to get the product of the inputs

## Practical 3 - Complexity Analysis

### ThreeSumA 
Brief Description: 

#### Complexity Information

Performance Implications: performs extremely poorly on large input sizes

Time Complexity: O(n^3)

Auxiliary Space Complexity: in-place; there is no outside structure of significance in addition to the input being used 
                            to get the sum of the inputs

### ThreeSumB
Brief Description:

#### Complexity Information

Performance Implications: performs extremely poorly on large input sizes

Time Complexity: O(n^2)

Auxiliary Space Complexity: in-place; there is no outside structure of significance in addition to the input being used
                            to get the product of the inputs

## Practical 4 - Sorting

### BogoSort
Brief Description: 

#### Complexity Information

Performance Implications: does not work with large inputs; better solutions present; no structure to this sort

Time Complexity: Infinity due to infinite number of shuffles including repetition of shuffles and in-place sorting
                 as no extra memory is allocated to put elements as they are sorted

Auxiliary Space Complexity: in-place; there is no outside structure of significance in addition to the input being used
                            to get the sorted output

### BubbleSort
Brief Description: sorts an array by repeatedly swapping the adjacent elements if they are in the wrong order.

#### Complexity Information

Performance Implications: N/A

Time Complexity: O(n^2) due to the number of comparisons that need to happen in order to sort the array; O(n) is best 
                 case scenario

Auxiliary Space Complexity: in-place; there is no outside structure of significance in addition to the input being used
                            to get the sorted output

### SelectionSort
Brief Description: sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted 
                   part and putting it at the beginning

#### Complexity Information

Performance Implications: N/A

Time Complexity: O(n^2) due to the presence of a nested loop and number of comparisons that need to be performed based on
                 n - the length of the array

Auxiliary Space Complexity: in-place; there is no outside structure of significance in addition to the input being used
                            to get the sorted output

### MergeSort
Brief Description: a divide-and-conquer algorithm that sorts an array by dividing the input array into two halves, calls 
                   itself for the two halves, and then it merges the two sorted halves.

#### Complexity Information

Performance Implications: always performs O(n log n)

Time Complexity: O(n log n) always divides the array into two halves and takes linear time to merge two halves no matter
                 the size

Auxiliary Space Complexity: out-of-place as new spaces need to be created to store the divided halves of an array and so
                            forth through the recursive calls of merge sort

### QuickSort
Brief Description: a divide-and-conquer algorithm that sorts an array by picking the middle element as pivot and 
                   partitions the given array around the picked pivot

#### Complexity Information

Performance Implications: performs slower than merge sort on smaller inputs but much faster on largern inputs

Time Complexity: O(n) determined by pivot that is picked out of the group; also based on how much of the original 
                 list/array is sorted 

Auxiliary Space Complexity: in-place; there is no outside structure of significance in addition to the input being used
                            to manipulate the sorted output


## Practical 5 - Binary Search 

### Binary Search 
Brief Description: a searching algorithm used in a sorted array by repeatedly dividing the search interval in half

#### Complexity Information

Performance Implications: good performance hinges on the input being sorted

Time Complexity: O(log n) because the input is already sorted

Auxiliary Space Complexity: in-place; there is no outside structure of significance in addition to the input being used
                            to manipulate the sorted output

### Binary Search Recursive
Brief Description:

#### Complexity Information

Performance Implications: time performance is the same as the iterative solution, but uses more space than it

Time Complexity: O(log n) because the input is already sorted

Auxiliary Space Complexity: out-of-place; there is an outside structure being used in addition to the input to 
                            effectively sort the array

## Practical 6 - Brute Force Substring Search Algorithm and Knuth-Morris-Pratt
Brief Description: N/A

#### Complexity Information

Performance Implications: N/A

Time Complexity: N/A

Auxiliary Space Complexity: N/A

## Practical 7 - RLE

### String printRLE(final String input){
Brief Description: a function that takes in a string as a command line argument and returns a
                   compressed string that uses Run Length Encoding (RLE)

#### Complexity Information

Performance Implications: this would result in a bad outcome for strings that do not lend themselves to RLE

Time Complexity: O(n) because the algorithm is dependent of the length of the string being encoded

Auxiliary Space Complexity: in-place; there is no outside structure of significance in addition to the input being used 
                            to produce the RLE of the string

## Practical 8 - Huffman Compression

### compress()
Brief Description: Reads a sequence of 8-bit bytes from standard input; compresses them using Huffman codes 
                   with an 8-bit alphabet; and writes the results to standard output.

####Complexity Information

Performance Implications: Extremely slow the larger the files are

Time Complexity: O(n^2) as the process used to compress the file using the code table has to go through each character
                 present in the file and find the corresponding encoding and compress

Auxiliary Space Complexity: out-of-place; there is an outside structure(trie with nodes) being used in addition 
                            to the input to compress the file

### expand()
Brief Description: Reads a sequence of bits that represents a Huffman-compressed message from  standard input; 
                   expands them; and writes the results to standard output.

####Complexity Information

Performance Implications: N/A

Time Complexity: O(n log n) because the longer the file input of bytes and their respective encodings, the longer 
                 the expansion will take

Auxiliary Space Complexity: in-place; there is no outside structure in addition to the input being used to expand 
                            the file

## Practical 9 - Dynamic Programming

### fib(n)
Brief Description: Simple recursive implementation for calculating fibonacci series

#### Complexity Information 

Performance Implications: Performance declines as n increases and becomes substantially slow

Time Complexity: O(2^n) due to the redundancy of sub-problems being calculated unnecessarily

Auxiliary Space Complexity: in-place; no outside, temporary storage is used to complete calculation

### fibDp(n)
Brief Description: Improved iterative implementation of recursive fibonacci function to include dynamic programming

#### Complexity Information

Performance Implications: Performance declines as n increases and becomes substantially slow however is much quicker
                          than the simple recursive implementation

Time Complexity: O(N) mainly due to the number of for loop passes being based on the n input meanwhile
                 setting aside the constant time computations

Auxiliary Space Complexity: out-of-place; temporary storage is used to complete calculation
                            specifically, the array used to calculate the fibonacci series

### LCS(final String sOne, final String sTwo)
Brief Description: Longest Common String implementation to include dynamic programming

#### Complexity Information

Performance Implications: As the lengths of the string inputs grow, the longer the algorithm will take to complete

Time Complexity: O(N^2) mainly due to the number of passes in the nested for loop being based on the lengths of
                 strings being compared to find the LCS

Auxiliary Space Complexity: out-of-place; temporary storage is used to complete calculation
                            specifically, the table used to determine the maximum value

### knapsackBf(final int W, final int[] w, final int[] vals)
Brief Description:

#### Complexity Information

Performance Implications: will move drastically slower the larger array of weights and values get

Time Complexity: O(2^n) due to the redundancy of sub-problems being calculated unnecessarily

Auxiliary Space Complexity: in-place; no outside, temporary storage is used to complete calculation

### knapsackDp(final int W, final int[] w, final int[] vals){
Brief Description: Knapsack dynamic programming implementation with 0-1 property; no splitting


#### Complexity Information

Performance Implications: will dramatically improve the performance of larger arrays of weights and values

Time Complexity: O(N * W) mainly due to the function's dependency on the number of items and capacity weight
                 on the number of passes in the nested for loop

Auxiliary Space Complexity:  out-of-place; temporary storage is used to complete calculation
                             specifically, the table (2-D array) used to determine the maximum value
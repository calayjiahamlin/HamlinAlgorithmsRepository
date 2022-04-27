import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class BinarySearch {

    /**
     *
     * @param array
     * @param elem
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int binarySearch(final T[] array, final T elem, final Comparator<T> comparator){

        int fIndex = 0;
        int lIndex = array.length - 1;

        int mid = lIndex/2;

        while(fIndex <= lIndex) {
            if(comparator.compare(elem, array[mid]) == 0) {
                return mid;
            }
            else if (comparator.compare(elem, array[mid]) < 0) {
                lIndex = mid - 1;
                mid = (lIndex + fIndex) / 2;
            }
            else {
                fIndex = mid + 1;
                mid = (lIndex + fIndex) / 2;
            }
        }
        return -1;
    }

    /**
     *
     * @param array
     * @param elem
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int binarySearchRecursive(final T[] array, final T elem, final Comparator<T> comparator) {

        int fIndex = 0;
        int lIndex = array.length - 1;

        return binarySearchRecursive(array, elem, fIndex, lIndex, comparator);
    }

    /**
     *
     * @param array
     * @param elem
     * @param fIndex
     * @param lIndex
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int binarySearchRecursive(final T[] array, final T elem, int fIndex, int lIndex, final Comparator<T> comparator) {

        int mid = (lIndex + fIndex) / 2;

        if (comparator.compare(elem, array[mid]) == 0) {
            return mid;
        } else if (comparator.compare(elem, array[mid]) < 0) {
            lIndex = mid - 1;
            mid = (lIndex + fIndex) / 2;
            return binarySearchRecursive(array, elem, fIndex, lIndex, comparator);
        } else if (comparator.compare(elem, array[mid]) > 0) {
            fIndex = mid + 1;
            mid = (lIndex + fIndex) / 2;
            return binarySearchRecursive(array, elem, fIndex, lIndex, comparator);
        } else {
            return -1;
        }
    }

    /**
     *
     * @param list
     * @param elem
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int binarySearch(final List<T> list, final T elem, final Comparator<T> comparator) {

        int fIndex = 0;
        int lIndex = list.size() - 1;

        return binarySearch(list, elem, fIndex, lIndex, comparator);
    }

    /**
     *
     * @param list
     * @param elem
     * @param fIndex
     * @param lIndex
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int binarySearch(final List<T> list, final T elem, int fIndex, int lIndex, final Comparator<T> comparator) {

        int mid = (lIndex + fIndex) / 2;

        if (comparator.compare(elem, list.get(mid)) == 0) {
            return mid;
        } else if (comparator.compare(elem, list.get(mid)) < 0) {
            lIndex = mid - 1;
            mid = (lIndex + fIndex) / 2;
            return binarySearch(list, elem, fIndex, lIndex, comparator);
        } else if (comparator.compare(elem, list.get(mid)) > 0) {
            fIndex = mid + 1;
            mid = (lIndex + fIndex) / 2;
            return binarySearch(list, elem, fIndex, lIndex, comparator);
        } else {
            return -1;
        }
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int[] array = new int[10];
        List<Integer> list = new ArrayList<Integer>();

        char[] letter = new char[10];
        List<String> strings = new ArrayList<String>();

        for(int i = 0; i < array.length; i++) {
            System.out.print("Enter a number: ");
            int next = scan.nextInt();
            array[i] = next;
            list.add(next);
        }

        for(int i = 0; i < letter.length; i++) {
            System.out.print("Enter a letter: ");
            char next = scan.next().charAt(i);
            letter[i] = next;
        }

        for(int i = 0; i < 10; i++) {
            System.out.print("Enter a word: ");
            String next = scan.next();
            strings.add(next);
        }

        //binarySearch(array, elem, comparator);

    }
}

/**
 *

class StringSortLex implements Comparator<String> {

    /**
     *
     * @param one
     * @param two
     * @return

    public int compare(String one, String two) {
        return one.compareTo(two);
    }
}
*/

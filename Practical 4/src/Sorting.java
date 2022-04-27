import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;

public class Sorting {

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *
     * time and space complexity: Infinity due to infinite number of shuffles including repetition of shuffles and in-place sorting
     * as no extra memory is allocated to put elements as they are sorted
     *
     */
    public static <T extends Comparable<T>> void bogoSort(final List<T> list, final Comparator<T> comparator) {

        int counter = 0;

        while (!isSorted(list, comparator)) {
            Collections.shuffle(list);
            counter++;
        }
    }

    public static <T extends Comparable<T>> boolean isSorted(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            if (comparator.compare(list.get(i), list.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> void bogoSort(final T[] array, final Comparator<T> comparator) {
        int counter = 0;

        while (!isSorted(array, comparator)) {
            List<T> shuffled = Arrays.asList(array);
            Collections.shuffle(shuffled);
            shuffled.toArray(array);
            counter++;
        }
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] array, Comparator<T> comparator) {
        for (int i = 1; i < array.length; i++) {
            if (comparator.compare(array[i], array[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *
     * time and space complexity: O(N^2) due to nested for-loop and in-place sorting
     * as no extra memory is allocated to put elements as they are sorted
     *
     */
    public static <T extends Comparable<T>> void bubbleSort(final List<T> list, final Comparator<T> comparator) {
        int len = list.size();

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    T hold = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, hold);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(final T[] array, final Comparator<T> comparator) {
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    T hold = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = hold;
                }
            }
        }
    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *
     * time and space complexity: O(N^2) due to nested for-loop and in-place sorting
     * as no extra memory is allocated to put elements as they are sorted
     *
     */
    public static <T extends Comparable<T>> void selectionSort(final List<T> list, final Comparator<T> comparator) {
        int min;
        T hold;

        for (int i = 0; i < list.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(min), list.get(j)) > 0)
                    min = j;
            }
            hold = list.get(i);
            list.set(i, list.get(min));
            list.set(min, hold);
        }
    }

    public static <T extends Comparable<T>> void selectionSort(final T[] array, final Comparator<T> comparator) {

        int min;
        T hold;

        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[min], array[j]) > 0)
                    min = j;
            }
            hold = array[i];
            array[i] = array[min];
            array[min] = hold;
        }

    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *
     * time and space complexity: NlgN due to nested for-loop and out-of-place sorting
     * as extra memory is allocated to put elements as they are sorted
     *
     */
    public static <T extends Comparable<T>> void mergeSort(final List<T> list, final Comparator<T> comparator) {

        int len = list.size();

        if (len < 2) {
            return;
        }

        int mid = len / 2;
        List<T> left = new ArrayList<T>(list.subList(0, mid));
        List<T> right = new ArrayList<T>(list.subList(mid, len));

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    private static <T extends Comparable<T>> void merge(List<T> origin, List<T> lHalf, List<T> rHalf, Comparator<T> comparator) {

        int l = 0;
        int r = 0;

        for (int i = 0; i < origin.size(); i++) {
            if (l == lHalf.size()) {
                origin.set(i, rHalf.get(r));
                r++;
            } else if (r == rHalf.size()) {
                origin.set(i, lHalf.get(l));
                l++;
            } else if (comparator.compare(lHalf.get(l), rHalf.get(r)) < 0) {
                origin.set(i, lHalf.get(l));
                l++;
            } else {
                origin.set(i, rHalf.get(r));
                r++;
            }
        }
    }


    public static <T extends Comparable<T>> void mergeSort(final T[] array, final Comparator<T> comparator) {

        int len = array.length;

        if (len < 2) {
            return;
        }

        int mid = len / 2;
        T[] first = Arrays.copyOfRange(array, 0, mid);
        T[] second = Arrays.copyOfRange(array, mid, len);

        mergeSort(first, comparator);
        mergeSort(second, comparator);

        merge(array, first, second, comparator);

    }

    private static <T extends Comparable<T>> void merge(T[] origin, T[] lHalf, T[] rHalf, Comparator<T> comparator) {

        int l = 0;
        int r = 0;
        int i = 0;

        while (l < lHalf.length && r < rHalf.length) {
            if (comparator.compare(lHalf[l], rHalf[r]) < 0) {
                origin[i] = lHalf[l];
                i++;
                l++;
            } else {
                origin[i] = rHalf[r];
                i++;
                r++;
            }
        }
        while (l < lHalf.length) {
            origin[i] = lHalf[l];
            i++;
            l++;
        }
        while (r < rHalf.length) {
            origin[i] = rHalf[r];
            i++;
            r++;
        }
    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *
     * time and space complexity: 1/2 N^2 due to nested while-loop however recursive and in-place sorting
     * as no extra memory is allocated to put elements as they are sorted
     */
    public static <T extends Comparable<T>> void quickSort(final List<T> list, final Comparator<T> comparator) {

        // Shuffle the array.
        Collections.shuffle(list);
        qSort(list, 0, list.size() - 1, comparator);
    }


    public static <T extends Comparable<T>> void qSort(final List<T> list, int begin, int end, final Comparator<T> comparator) {

        int pivot;

        if (end <= begin) {
            return;
        }
        pivot = partition(list, begin, end, comparator);
        qSort(list, begin, pivot - 1, comparator);
        qSort(list, pivot + 1, end, comparator);

    }

    private static <T extends Comparable<T>> void swap(List<T> list, int begin, int pivot) {
        T hold = list.get(begin);
        list.set(begin, list.get(pivot));
        list.set(pivot, hold);
    }

    private static <T extends Comparable<T>> int partition(List<T> list, int begin, int end, Comparator<T> comparator) {

        int i = begin;
        int j = end + 1;

        while (true) {
            while (comparator.compare(list.get(++i), list.get(begin)) < 0) {
                if (i == end) {
                    break;
                }
            }
            while (comparator.compare(list.get(begin), list.get(--j)) < 0) {
                if (j == begin) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(list, i, j);
        }
        swap(list, begin, j);
        return j;
    }


    public static <T extends Comparable<T>> void quickSort(final T[] array, final Comparator<T> comparator) {

        // shuffle
        List<T> shuffled = Arrays.asList(array);
        Collections.shuffle(shuffled);
        shuffled.toArray(array);

        qSort(array, 0, array.length - 1, comparator);
    }

    public static <T extends Comparable<T>> void qSort(final T[] array, int begin, int end, final Comparator<T> comparator) {

        int pivot;

        if (end <= begin) {
            return;
        }
        pivot = partition(array, begin, end, comparator);
        qSort(array, begin, pivot - 1, comparator);
        qSort(array, pivot + 1, end, comparator);

    }

    private static <T extends Comparable<T>> void swap(T[] array, int begin, int pivot) {
        T hold = array[begin];
        array[begin] = array[pivot];
        array[pivot] = hold;
    }

    private static <T extends Comparable<T>> int partition(T[] array, int begin, int end, Comparator<T> comparator) {

        int i = begin;
        int j = end + 1;

        while (true) {
            while (comparator.compare(array[++i], array[begin]) < 0) {
                if (i == end) {
                    break;
                }
            }
            while (comparator.compare(array[begin], array[--j]) < 0) {
                if (j == begin) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, begin, j);
        return j;
    }
}


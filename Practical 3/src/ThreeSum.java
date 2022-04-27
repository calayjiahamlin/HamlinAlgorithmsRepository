import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
    private static final List<String> filePaths = new ArrayList<>();

    static {
        filePaths.add("resources/1Kints.txt");
        filePaths.add("resources/2Kints.txt");
        filePaths.add("resources/4Kints.txt");
        filePaths.add("resources/8Kints.txt");
        filePaths.add("resources/16Kints.txt");
    }

    public static void main(final String[] args) throws IOException {
        for (final String path : filePaths) {
            // do something
            System.out.println(path);
            int[] numbers = loadFileAsIntArray(path);

            long startTimeA = System.nanoTime();
            System.out.println(threeSumA(numbers));
            long endTimeA = System.nanoTime();

            long startTimeB = System.nanoTime();
            System.out.println(threeSumB(numbers));
            long endTimeB = System.nanoTime();

            long durationA = (endTimeA - startTimeA);
            long durationB = (endTimeB - startTimeB);

            System.out.println((durationA/1000000) + " " + "in milliseconds");
            System.out.println((durationB/1000000) + " " + "in milliseconds");
        }
    }

    public static int threeSumA(final int[] array) {        //The time complexity of threeSumA is O(n^3)
        final int length = array.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int threeSumB(final int[] array) {        //The time complexity of threeSumB is O(n^2)
        final int length = array.length;
        Arrays.sort(array);
        if (Arrays.stream(array).distinct().toArray().length != length) {
            throw new IllegalArgumentException("Input array contains duplicates");
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int k = Arrays.binarySearch(array, -(array[i] + array[j]));
                if (k > j) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] loadFileAsIntArray(final String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath)).stream().mapToInt(Integer::parseInt).toArray();
    }
}

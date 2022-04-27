public class RleStrings {
    public static String printRLE(final String input){

        int n = input.length();
        String output = "";
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            output = output + input.charAt(i) + count;
        }
        return output;
    }
}

/**
 * java BinaryDump 40 < 4runs.bin (number of bits)
 * 40 bits
 * java RunLength - < 4runs.bin | java BinaryDump (compress)
 * 32 bits
 * compression ratio = 40/32 = 1.25
 * java RunLength - < 4runs.bin > 4runsrle.bin
 * java BinaryDump < 4runsrle.bin
 */

/**
 * java BinaryDump 8 < abra.txt
 * 96 bits
 * java RunLength - < abra.txt | java BinaryDump 8
 * 416 bits
 * compression ratio = 96/416 = 0.23
 * RLE only works when there are long and redundant strings
 *      of a single character; here there were bits added
 *      to encode the count of each character's run length
 * java BinaryDump 8 < abra.txt
 * 96 bits
 * java RunLength - < abra.txt | java BinaryDump 8
 * 416 bits
 * compression ratio = 96/416 = 0.23
 */
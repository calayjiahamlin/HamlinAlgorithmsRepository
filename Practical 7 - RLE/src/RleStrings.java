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
 * ?RLE only works when there are long and redundant strings
 *   of a single character; here there were bits added
 *   to encode the count of each character's run length?
 */

/**
 * java BinaryDump 8 < create.txt
 * 328 bits
 * java RunLength - < abra.txt | java BinaryDump 8
 * 416 bits
 * compression ratio = 96/416 = 0.23
 */

/**
 * bitmap file q32x48.bin
 * 1536 bits
 * java RunLength - < q32x48.bin | java BinaryDump
 * 1144 bits
 * compression ratio = 1144/1536 = 0.74
 * bitmap file q64x96.bin
 * 6144 bits
 * java RunLength - < q64x96.bin | java BinaryDump
 * 2296 bits
 * compression ratio = 6144/2296 = 2.68
 *
 * The difference between the two compression ratios of the bitmaps
 * is most likely due to the second bitmap being longer and larger
 * than the last. The likelihood that there are longer strings of
 * redundant characters is higher in longer and larger files than in
 * smaller files.
 */
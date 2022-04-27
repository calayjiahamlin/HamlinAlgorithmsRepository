

public class Huffman {
    // alphabet size of extended ASCII
    private static final int R = 256;


    // Huffman trie node
    private record Node(char ch, int freq, Huffman.Node left, Huffman.Node right) implements Comparable<Node> {

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return left == null;
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress() {
        // read the input
        String input = BinaryStdIn.readString();
        char[] inputChar = input.toCharArray();

        int[] freq = new int[R];
        for (int i = 0; i < inputChar.length; i++)
            freq[inputChar[i]]++;

        // build Huffman trie
        Node root = null; //buildTrie(freq);

        // build code table
        String[] st = new String[R];
        //buildCode(st, root, "");

        // print trie for decoder
        writeTrie(root);

        // print number of bytes in original uncompressed message
        BinaryStdOut.write(inputChar.length);

        // use Huffman code to encode input
        for (int i = 0; i < inputChar.length; i++) {
            String code = st[inputChar[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    BinaryStdOut.write(false);
                }
                else if (code.charAt(j) == '1') {
                    BinaryStdOut.write(true);
                }
                else throw new IllegalStateException("Illegal state");
            }
        }

        // close output stream
        BinaryStdOut.close();
    }



    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }


    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void expand() {
        Node root = null; //readTrie();
        int N = BinaryStdIn.readInt();
        for (int i = 0; i < N; i++)
        {
            Node x = root;
            while (!x.isLeaf())
            {
                if (!BinaryStdIn.readBoolean())
                    x = x.left;
                else
                    x = x.right;
            }
            BinaryStdOut.write(x.ch, 8);
        }
        BinaryStdOut.close();
    }


    public static void main(String[] args) {
        if (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}

import java.util.PriorityQueue;

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
     * Much of this code was heavily influenced by the code at the following url:
     * https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Huffman.java
     *
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress() {
        String input = BinaryStdIn.readString(); //read the input of the file
        char[] inputChar = input.toCharArray(); //place the input into a character array

        int[] f = new int[R]; //create an array that stores the frequency of each character in the file
        for (int i = 0; i < inputChar.length; i++) { //store the frequency of each character from the input
            f[inputChar[i]]++;
        }

        PriorityQueue<Node> trie = new PriorityQueue<Node>(); //priority queue is used to store the nodes of each
        for (char c = 0; c < R; c++) {                        //character to include frequency in order from least to greatest
            if (f[c] > 0) {
                trie.add(new Node(c, f[c], null, null)); //adding a new node for each character present in the input
            }
        }

        while (trie.size() > 1) { //merging the two trees of the smallest frequency until there is only one tree left
            Node left  = trie.remove();
            Node right = trie.remove();
            Node parent = new Node('-', left.freq + right.freq, left, right);
            trie.add(parent);
        }
        Node root = trie.remove(); // store huffman tree in root node

        String[] codes = new String[R]; //create a table to store the codes of each character
        codeTable(codes, root, "");
        writeTrie(root); // print tree
        BinaryStdOut.write(inputChar.length); // prints the number of bytes in original file(uncompressed)

        for (int i = 0; i < inputChar.length; i++) {// use code table to compress original file
            String code = codes[inputChar[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    BinaryStdOut.write(false);
                }
                if (code.charAt(j) == '1') {
                    BinaryStdOut.write(true);
                }
            }
        }
        BinaryStdOut.close();
    }

    /**
     *
     * @param codes: string array used to store the codes of corresponding nodes
     * @param n: node holding a char
     * @param str: string used to store the code of a node(char)
     */
    public static void codeTable(String[] codes, Node n, String str) {
        if (!n.isLeaf()) { //adds a 1 or 0 to code if node is not a leaf
            codeTable(codes, n.left,  str + '0');
            codeTable(codes, n.right, str + '1');
        }
        else { //stores code in table if code is a leaf
            codes[n.ch] = str;
        }
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
     * Much of this code was heavily influenced by the code at the following url:
     * https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Huffman.java
     *
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void expand() {

        Node root = readTrie(); //read in huffman trie from input

        int N = BinaryStdIn.readInt();
        for (int i = 0; i < N; i++) {
            Node n = root;
            while (!n.isLeaf()) {
                if (!BinaryStdIn.readBoolean()) {
                    n = n.left;
                }
                else {
                    n = n.right;
                }
            }
            BinaryStdOut.write(n.ch, 8);
        }
        BinaryStdOut.close();
    }

    public static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(), -1, null, null); //the base case and creates a leaf node
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie()); //recursively recreates the tree
        }
    }

    public static void main(String[] args) {
        if (args[0].equals("-")){
            compress();
        }
        else if (args[0].equals("+")){
            expand();
        }
        else {
            throw new IllegalArgumentException("Illegal command line argument");
        }
    }
}

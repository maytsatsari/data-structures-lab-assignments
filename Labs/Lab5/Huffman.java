
import java.io.*;

public class Huffman {

    private int n;          // number of different letters
    private char[] C;       // array containing all letters from a to z
    private int[] F;        // array containing the frequency (number of occurencies) of each letter
    private String[] code;  // array containing the Huffman code of each letter

    // Huffman tree node
    private class Node {

        public char c;     // letter stored at node
        public Node left;  // left child
        public Node right; // right child

        // create new tree node
        Node(char c, Node left, Node right) {
            this.c = c;
            this.left = left;
            this.right = right;
        }
		
		

    }

    public Huffman(int N) {
        n = N;
        // initialize C with the characters from a to z
        C = new char[n + 1];
        char j = 'a';
        for (int i = 1; i <= n; i++, j++) {
            C[i] = j;
        }

        // initialize F with 0
        F = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            F[i] = 0;
        }

        // initialize code
        code = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            code[i] = "";
        }
    }

    // count the letters in word s
    private void processWord(String s) {
        int c;
        for (int i = 0; i < s.length(); i++) {
            // if letter c is in upper case convert it to lower case
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                c = s.charAt(i) + 32;
                F[c - 96]++;
            } // do not convert if already in lower case
            else if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                c = s.charAt(i);
                F[c - 96]++;
            }
        }
    }

    // print the total number of occurrences of each letter
    private void printCount() {
        for (int i = 1; i <= n; i++) {
            System.out.println("letter = " + C[i] + ", count = " + F[i]);
        }
        System.out.println("");
    }

    // print Huffman code
    private void printCode() {
        for (int i = 1; i <= n; i++) {
            if (F[i] != 0) {
                System.out.println("letter " + C[i] + ", code = " + code[i]);
            }
        }
    }

   
    // encode letters by running Huffman algorithm 
    private void encode() {
		
        MinPQ<Node, Integer> PQ = new MinPQ<Node, Integer>(n);
        for (int i = 1; i <= n; i++) {
            if (F[i] == 0) { // ignore letters that do not appear in input file
                continue;
            }
            Node x = new Node(C[i], null, null); // construct new leaf node
            //System.out.println("insert item " + C[i] + " key " + F[i]);
            PQ.insert(x, F[i]);
        }
        
		while(PQ.size()>1)
		{
		
			Node i1=PQ.minItem();
			int k1=PQ.minKey();
			
			PQ.delMin();
			
			Node i2=PQ.minItem();
			int k2=PQ.minKey();
			PQ.delMin();
			
			Node x = new Node('_', i1, i2);
			PQ.insert(x, k1+k2);
		}
		Node top=PQ.minItem();
		
		
		
		for (int i = 1; i <= n; i++)
		{
			getCode(top,i, "");
			
		}
		
        /* enter your code! */
    }
	
	void getCode(Node x,int i, String cd) {
			
			if (x.c == C[i]) {code[i]=cd;}
			if(x.left!=null){
		
				getCode(x.left,i, cd + "1");
			}
			if(x.right!=null){
				getCode(x.right,i, cd + "0");
			}
			
			
		}  

    public static void main(String[] args) {
        System.out.println("Test Huffman coding");

        Huffman H = new Huffman(26);

        In.init();
        long startTime = System.currentTimeMillis();
        while (!In.empty()) {
            String s = In.getString();
            if (s.isEmpty()) {
                continue;
            }
            H.processWord(s);
        }
        H.printCount();
        H.encode();
        H.printCode();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total running time = " + totalTime);
    }
}

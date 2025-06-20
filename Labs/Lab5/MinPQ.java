
import java.io.*;
import java.util.Random;

// minimum priority queue implemented with a binary heap
public class MinPQ<Item, Key extends Comparable<Key>> {

    private int N;    // number of items on priority queue
    private Key  pqK[]; // binary heap of keys
    private Item pqI[]; // binary heap of items

    public MinPQ(int maxN) {
        pqK = (Key[]) new Comparable[maxN + 1];
        pqI = (Item[]) new Object[maxN + 1];
        N = 0;
    }
 
    // return the number of elements in the priority queue
    public int size() {
        return N;
    }

    // insert item v with key k
    public void insert(Item v, Key k) {
		
		pqK[N]=k;
		pqI[N]=v;
		N++;
		for (int i=1;i<N-1;i++)
		{
			boolean f=true;
			for (int j=N-1;j>=i;j--)
			{
				if(pqK[j].compareTo(pqK[j-1])<0)
				{
					Item tmp=pqI[j];
					pqI[j]=pqI[j-1];
					pqI[j-1]=tmp;
					
					Key tmp2=pqK[j];
					pqK[j]=pqK[j-1];
					pqK[j-1]=tmp2;
					
					f=false;
					
				}
				
				
			}
			
			if(f) break;
		}
		
		
		
   
    }

    // return the item with minimum key
    public Item minItem() {
        return pqI[0];
    }
    
    // return the minimum key
    public Key minKey() {
        return pqK[0];
    }
    
    // delete the item with minimum key
    public void delMin() {
		
		
		N--;
        for (int i=0;i<N;i++)
		{
			pqI[i]=pqI[i+1];
			pqK[i]=pqK[i+1];
			
		}
		
		
	
    }

    private void printPQ() {
        System.out.println("");
        for (int i = 1; i <= N; i++) {
            System.out.println("" + i + ": item = " + pqI[i] + ", key = " + pqK[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("Test Min Priority Queue implemented with a Binary Heap");

        long startTime = System.currentTimeMillis();
        MinPQ<Character,Integer> PQ = new MinPQ<Character,Integer>(26);
        Random rand = new Random(0);

        System.out.println("");
        System.out.println("Inserting keys");
        System.out.println("");
        for (int i = 1; i <= 26; i++) {
            int key = rand.nextInt(100); // assign random keys
            char c = (char) (96 + i);
            System.out.println("insert item " + c + " key " + key);
            PQ.insert(c, key);
        }
        //PQ.printPQ();
        
        System.out.println("");
        System.out.println("Deleting minimum keys");
        System.out.println("");
        while (PQ.size()>0) {
            char c = (char) PQ.minItem();
            int k = PQ.minKey();
            PQ.delMin();
            System.out.println("item " + c + " key " + k);
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total time = " + totalTime);
    }
}

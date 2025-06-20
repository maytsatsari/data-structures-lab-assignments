
import java.io.*;

public class LinearProbingHT<Key,Value> {

    private class Pair {
        Key key;
        Value value;
        
        Pair(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private int m;      // hash table size
    private Pair[] T;   // hash table
    private int n;      // number of distinct items inserted
    
    int probes;

    private int totalComparisons; // number of item comparisons for all insertions

    public int totalComparisons() {
        return totalComparisons;
    }
    
    // hash function
    private int hash(Key key) {
        return ( (key.hashCode() & 0x7fffffff) % m);
    }

    // linear probing
    private int hashL(int k, int i)
    {
        return ( (k + i) % m );
    }
    
    // constructor: initialize empty hash table of size M
    LinearProbingHT(int M)
    {
        m = M;
        n = 0;
        T = new LinearProbingHT.Pair[m]; 
    }

    public double loadFactor()
    {
        return (double) 100*n/m;
    }
    
    // insert key with associated value
    public void insert(Key key, Value value) {
        int k=hash(key);
        for (int i=0;i<m;i++)
        {
        
        	totalComparisons++;
        	if(T[hashL(k,i)]==null)
        	{
        		n++;
        		
        		T[hashL(k,i)]=new Pair(key,value);
        		
        		if(loadFactor()>90)
        		{
        			m=m*2;
        			LinearProbingHT L = new LinearProbingHT<Key,Value>(m);
        			for (int j=0;j<m/2;j++)
        			{
        				if(T[j]!=null)
        				{
        				
        				
        					L.insert(T[j].key,T[j].value);
        					
        				}
        			}
        			T=L.T;
        		
        		}
			
        		break;
        	
        	}
        	else
        	if(T[hashL(k,i)].key.equals(key))
        	{
        	
        		T[hashL(k,i)].value=value;
        		break;
        	
        	}
        	
        
        }
    }
       
    // return the value associated with key
    public Value contains(Key key)
    {
         int k=hash(key);
        for (int i=0;i<m;i++)
        {
        
        
        	if(T[hashL(k,i)]==null)
        	{
        		
        		break;
        	
        	}
        	else
        	if(T[hashL(k,i)].key.equals(key))
        	{
        	
        		return T[hashL(k,i)].value;
        	
        	}
        
        }
        return null; // change appropriately
    }

    // print hash table 
    void print()
    {
        for (int j=0; j<m; j++) {
            if (T[j] == null) {
                System.out.println("T["+j+"]=");
                continue;
            }
            System.out.println("T["+j+"]=" + "(" + T[j].key + "," + T[j].value + ") ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Hash Table with Linear Probing");

        int M = 11; // initial hash table size
        LinearProbingHT T = new LinearProbingHT<String,Integer>(M);
        
        In.init();
        long startTime = System.currentTimeMillis();
        while (!In.empty()) {
            String s = In.getString();
            Integer count = (Integer) T.contains(s);
            if ( count != null ) {
                T.insert(s, count + 1);
            } else {
                T.insert(s, 1);
            }
        }
//        T.print();
        long endTime = System.currentTimeMillis();
        long chtTime = endTime - startTime;
        System.out.println("construction time = " + chtTime);
        System.out.println("total number of item comparisons  = " + T.totalComparisons());
        System.out.println("load factor = " + T.loadFactor());
        
        System.out.println("contains 'and' " + T.contains("and") + " times");
        System.out.println("contains 'astonished' " + T.contains("astonished") + " times");
        System.out.println("contains 'boat' " + T.contains("boat") + " times");
        System.out.println("contains 'path' " + T.contains("path") + " times");
        System.out.println("contains 'the' " + T.contains("the") + " times");
        System.out.println("contains 'train' " + T.contains("train") + " times");
        System.out.println("contains 'tom' " + T.contains("tom") + " times");
        System.out.println("contains 'wondered' " + T.contains("wondered") + " times");
        
        endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total running time = " + totalTime); 
    }
}

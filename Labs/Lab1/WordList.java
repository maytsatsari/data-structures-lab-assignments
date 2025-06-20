
import java.io.*;

public class WordList {

    private class Node {
        String str;
        int count;   // occurrences of str in input file
        Node next;   // next node in linked list

        Node(String str) {
            this.str = str;
            this.next = null;
            this.count = 1;
        }
    }

    private Node first;     // first node of the linked list
    private int nodeCount;  // number of nodes

    public WordList() {
        this.nodeCount = 0;
    }

    int nodeCount() {
        return nodeCount;
    }

    // return the number of occurrences of word s in the input file
    public int contains(String s) {
        /* enter you code! */
        // s not found
		if(nodeCount()==0)
		{
			return 0;
		}
		else
		{
			Node n=this.first;
			
			while(true)
			{
					
					if(n==null)
					{
						
						break;
			
					}
					else
					{
						if(n.str.equals(s))
						{
							return n.count;
						}
						else
						{
							n=n.next;
						}
					}
					
			}
			
				
		}
		
		
		
        return 0;
    }

    // add one more occurence of word s; insert new node if s is not in the linked list
    public void insert(String s) {
        /* enter you code! */
		if(nodeCount()==0)
		{
			Node n=new Node(s);
			this.first=n;
			this.nodeCount++;
			
		}
		else
		{
			Node n=this.first;
			while(true)
			{
				if(n.str.equals(s))
				{
					n.count++;
					return;
				}
				else
				{
					if(n.next==null)
					{
						Node n2=new Node(s);
						this.nodeCount++;
						n.next=n2;
						return;
			
					}
					else
					{
						n=n.next;
					}
					
				}
				
			}
			
		}
		
		
    }

    // delete word s from the linked list
    public void delete(String s) {
        /* enter you code! */
		if(nodeCount()==0)
		{
			return ;
		}
		else
		{
			Node old=null;
			Node n=this.first;
			
			while(true)
			{
					
					if(n==null)
					{
						
						break;
			
					}
					else
					{
						if(n.str.equals(s))
						{
							if(old==null)
							{
								this.first=n.next;
								n=null;
							}
							else
							{
								old.next=n.next;
								n=null;
								
							}
							return ;
						}
						else
						{
							old=n;
							n=n.next;
						}
					}
					
			}
			
				
		}
		
		
		
		
    }

    // sort linked list in decreasing word frequencies 
    public void freqOrder() { 
        /* enter you code! */
		if(nodeCount()==0)
		{
			return ;
		}
		else
		{
			int N=nodeCount();
			for (int j=N-1;j>=0;j--)
			{
				Node n=this.first;
				for (int i=0;i<j;i++)
				{
					Node n2=n.next;
					if(n.count<n2.count)
					{
						String tmp=n.str;
						int tmpc=n.count;
												
						n.str=n2.str;
						n.count=n2.count;
						n2.str=tmp;
						n2.count=tmpc;
						

					}
					n=n.next;
					
				}
				
			}
		
		}
		
		
    }
    
    // sort linked list in lexicographic order of words 
    public void lexOrder() {
        /* enter you code! */
		if(nodeCount()==0)
		{
			return ;
		}
		else
		{
			int N=nodeCount();
			for (int j=N-1;j>=0;j--)
			{
				Node n=this.first;
				for (int i=0;i<j;i++)
				{
					Node n2=n.next;
					if(n.str.compareTo(n2.str)>0)
					{
						String tmp=n.str;
						int tmpc=n.count;
												
						n.str=n2.str;
						n.count=n2.count;
						n2.str=tmp;
						n2.count=tmpc;
						

					}
					n=n.next;
					
				}
				
			}
		
		}
		
		
		
		
		
    }
    
    // find the k-th word in the linked list
    public String select(int k) {
        /* enter you code! */
		if(nodeCount()==0)
		{
			return null;
		}
		else
		{
			Node n=this.first;
			int i=0;
			while(i<k)
			{
					
					if(n==null)
					{
						
						break;
			
					}
					else
					{
												
						i++;
						if(i==k)
						{
							return n.str;
						}
						n=n.next;
						
					}
					
			}
			
				
		}
		
		 
		
        return null; // change appropriately
    }
    
    // print first k strings of linked list
    public void print(int k) {
        /* enter you code! */
		if(nodeCount()==0)
		{
			System.out.println("empty list");
		}
		else
		{
			Node n=this.first;
			int i=0;
			while(i<k)
			{
					System.out.print(n.str+" ");
					if(n.next==null)
					{
						
						break;
			
					}
					else
					{
						n=n.next;
						i++;
					}
					
			}
			System.out.println();
				
		}
		
		
    }
    
    public static void main(String[] args) {
        System.out.println("Test WordList");

        WordList L = new WordList();

        In.init();
        long startTime = System.currentTimeMillis();
        while (!In.empty()) {
            String s = In.getString();
            if (s.isEmpty()) continue;
            L.insert(s);
        }
        long endTime = System.currentTimeMillis();
        long listTime = endTime - startTime;
        System.out.println("linked list construction time = " + listTime);
        System.out.println("number of linked list nodes = " + L.nodeCount());
        System.out.println("");

        System.out.println("contains 'and' " + L.contains("and") + " times");
        System.out.println("contains 'astonished' " + L.contains("astonished") + " times");
        System.out.println("contains 'boat' " + L.contains("boat") + " times");
        System.out.println("contains 'path' " + L.contains("path") + " times");
        System.out.println("contains 'the' " + L.contains("the") + " times");
        System.out.println("contains 'train' " + L.contains("train") + " times");
        System.out.println("contains 'tom' " + L.contains("tom") + " times");
        System.out.println("contains 'wondered' " + L.contains("wondered") + " times");
        System.out.println("");

        System.out.println("sorting words in lexicographical order");
        L.lexOrder();
        System.out.println("first 10 words in lexicographical order are:");
        L.print(10);
        String s = L.select(100);
        System.out.println("100th word in lexicographical order = " + s + "(" + L.contains(s) + ")");
        System.out.println("");
        
        System.out.println("sorting list in decreasing word frequency order");
        L.freqOrder();
        System.out.println("the 10 most frequent words are:");
        L.print(10);
        s = L.select(100);
        System.out.println("100th most frequent word = " + s + "(" + L.contains(s) + ")");
        System.out.println("");
        
        System.out.println("deleting '" + s +"'");
        L.delete(s);
        String t = L.select(100);
        System.out.println("next most frequent word after '" + s + "' = " + t + "(" + L.contains(t) + ")");
        System.out.println("");
        
        endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total running time = " + totalTime);
    }
}

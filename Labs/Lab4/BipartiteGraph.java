

import java.io.*;
import java.util.*;

public class BipartiteGraph {

    private final int N;                // number of vertices
    private int K;                      // number of edges
    private Collection<Integer>[] adj;  // adjacency lists
	private int color[];
    // construct graph with N nodes and no edges
    public BipartiteGraph(int N) {
        this.N = N;
        this.K = 0;
		color=new int[N];
        adj = (Collection<Integer>[]) new Collection[N];  // array of references to collections
        for (int i = 0; i < N; i++) {
            adj[i] = new Collection<Integer>();   // initialize collections to be empty
        }
		
		for (int i=0;i<N;i++)
		{
			color[i]=-1;
		}
    }

    public int nodes() // return the number of nodes
    {
        return N;
    }

    public int edges() // return the number of edges
    {
        return K;
    }

    // add edge {v,w}
    public void addEdge(int v, int w) {
        adj[v].insert(w);
        adj[w].insert(v);
        K++;
    }

    // nodes adjacent to node v
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // print adjacency lists
    public void printGraph() {
        System.out.println("adjacency lists");
        for (int v = 0; v < N; v++) {
            System.out.print(v + " :");
            for (int w : adj(v)) {
                System.out.print(w + " ");
            }
            System.out.println("");
        }
    }

    // breadth-first search from vertex s
    void bfs(int s) {
		boolean visited[] = new boolean[this.N];
		int c=0;
		Queue<Integer> queue = new Queue<Integer>();

		visited[s] = true;
		queue.insert(s);
		color[s]=c;

		while (queue.size() != 0) {
		  s = queue.remove();
		  
		  if(color[s]==0) c=1;
			else c=0;
		  
		  for (int w : adj(s))
		  {
			
			if (!visited[w]) {
			  visited[w] = true;
			  if(color[w]==-1) color[w]=c;
			  
			  queue.insert(w);
			}
			if(color[w]==color[s])
			{

				  System.out.println("Input graph is NOT Bipartite!");
				 
				 
				  Queue<Integer> queue2=findOddCycle(s, w);
				  printCycle(queue2);
				  return;
			}
			
		  }
		}
		
		System.out.println("Input graph is Bipartite!");
		
      
    }

    // find odd-length cycle containing edge (u,v)
    Queue<Integer> findOddCycle(int u, int v) {
        Queue<Integer> C = new Queue<Integer>();
        Stack<Integer> S = new Stack<Integer>();
		
		Stack<Integer> tmp = new Stack<Integer>();
		boolean visited[] = new boolean[this.N];
		int c=0;
		int s=u;	
		int i=0;
		
		S.push(s);
		
		while (S.size() != 0) {
			
			  s = S.pop();
			  
			  if (!visited[s]) {
				  C.insert(s);
				  visited[s] = true;
			  }
		  
			  if(s==v ) break;			
			  for (int w : adj(s))
			  {
				  if(!visited[w]) {
					  if(i==0 && w==v) continue;
						tmp.push(w);
						
					
				  }
			  }
			  while (!tmp.empty())
			  {
				  S.push(tmp.pop());
			  }
				i=1;
			
		  }
		
		
		
        return C;
    }

    // print cycle stored in queue C
    void printCycle(Queue<Integer> C) {
        /* enter your code */
		
		System.out.println("Odd cycle found");
        
            System.out.print("Cycle : (");
            for (int w : C.getList()) {
                System.out.print(w + " ");
            }
            System.out.println(")");
        
    }

    public static void main(String[] args) {
        In.init();
        int N = In.getInt();
        BipartiteGraph G = (BipartiteGraph) new BipartiteGraph(N);
        int K = In.getInt();
        for (int i = 0; i < K; i++) {
            int v = In.getInt();
            int w = In.getInt();
            G.addEdge(v, w);
        }
        G.printGraph();
        G.bfs(0);
		
    }
}

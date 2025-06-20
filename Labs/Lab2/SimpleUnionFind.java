
import java.io.*;

public class SimpleUnionFind {

    private int[] Pi;     // parent array
    private int N;        // number of items

    SimpleUnionFind(int N) {
        this.N = N;
        Pi = new int[N + 1];
        for (int k = 0; k <= N; k++) 
		{
            Pi[k] = k;
        }
    }

    int find(int v) {
        /* enter your code */
		int k=v;
		
		while(k!=Pi[k])
		{
			
			k=Pi[k];
		}
        return k; // change appropriately 
    }

    void unite(int v, int u) {
		int v1=find(v);
		int u1=find(u);
		if(v1!=u1)	Pi[u1]=v1;
        /* enter your code */
    }
    
    int setCount() {
        /* enter your code */
		int c=0;
		for (int i=1;i<=this.N;i++)
		{
			if(Pi[i]==i) c++;
		}
		
        return c; // change appropriately 
    }
    
    void print() {
        System.out.println("Simple Set Union Data Structure");
        for (int k=1; k<=N; k++) {
            System.out.println("Pi["+k+"]="+Pi[k]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Test SimpleUnionFind");

        int N = 16; 
        SimpleUnionFind SUF = new SimpleUnionFind(N);
        
        for (int k=1; k<=3; k++){
            SUF.unite(k+1,k);
            SUF.unite(k+5,k+4);
            SUF.unite(k+9,k+8);
            SUF.unite(k+13,k+12);
        }
        SUF.unite(1,5);
        SUF.unite(9,13);
        SUF.print();
        SUF.unite(1,13);
        SUF.find(2);
        SUF.print();
    }
}

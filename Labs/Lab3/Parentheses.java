
import java.io.*;

public class Parentheses {

    private static void PrintOutput(Queue<Integer> Q) {
      while(!Q.isEmpty())
	  {
		  System.out.println("range ="+Q.get()+","+Q.get());
	  }
    }

    private static void ParseInput(String str) {
        Stack<Pair> S = new Stack<Pair>();
        Queue<Integer> Q = new Queue<Integer>();

        int N = str.length(); // number of characters in str
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i); // character at position i of str
			if(c!='(' && c!='[' && c!='{' && c==')' && c==']' && c=='}')
				{
					continue;
				}
			System.out.println("i = "+i+","+c);
			if(c=='(' || c=='[' || c=='{')
				{
					
					Pair p=new Pair(c,i);
					
					S.push(p);
					
				}
				
			if(c==')' || c==']' || c=='}')
				{
					Pair p;
					p=S.pop();
					
				if((c==')' && p.getC()=='(') || (c==']' && p.getC()=='[') || (c=='}' && p.getC()=='{')) {
						
						Q.put(p.getP());
						Q.put(i);
					}
					else
					{
						System.out.println("Syntax error!");
						return;
					}
					
					
				}	
				
            /* enter your code! */
        }
		System.out.println("Syntax is correct!");
        PrintOutput(Q);
    }

    public static void main(String[] args) {
        System.out.print("Enter input string > ");
        In.init();
        String str = In.getString();   // read next character
        System.out.println("Input string = " + str + " , length = " + str.length());

        ParseInput(str);
    }
}

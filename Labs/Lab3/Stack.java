
public class Stack<Item> {
	Item S[];
	int last;
	
    Stack() {
		
		S=(Item[]) (new Object[1000]);
		last=0;
       
    }

    boolean isEmpty() {
		if(last==0)
			return true; 
		else// change appropriately
			return false;
	}

    // insert new item on top of the stack
    void push(Item item) {
		
		S[last]=item;
		last++;
       
    }

    // extract most recent item from the top of the stack
    Item pop() {
        if(!isEmpty())
		{
			last--;
			return S[last];
        }
		else
			return null; // change appropriately
    }
}


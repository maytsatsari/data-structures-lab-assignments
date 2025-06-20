
class Queue<Item> {
    int left,right;
	Item[] Q;
	
    Queue() {
		left=-1;
		right=-1;
      Q=(Item []) new Object[1000]; 
    }
    
    boolean isEmpty() {
		if(left==-1 && right==-1)
			return true; // change appropriately
		else	
			return false;
	}

    // insert new item in the queue
    void put(Item item) {
		if(isEmpty())
		{
			left=0;right=0;
			Q[right]=item;
		}
		else
		{
			right++;
			Q[right]=item;
			
		}
		
		
        
    }

    // extract least recent item from the queue
    Item get() {
		if(!isEmpty())
		{
			Item r=Q[left];
			left++;
			if(left>right)
			{
				left=-1; right=-1;
			}
			return(r);
		}
		else
        return null; // change appropriately
    }
}

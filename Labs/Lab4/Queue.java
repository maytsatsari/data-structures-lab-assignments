
import java.util.ArrayList;

class Queue<Item> { 
    
	ArrayList<Item> Q;
    Queue()
	{
		Q=new ArrayList<Item>();
		
		
	}
	
	void insert(Item q)
	{
		
		Q.add(q);
	}
	
	
	
	
 
	Item remove()
	{
		Item q;
		q=Q.get(0);
		Q.remove(q);
		return q;
	}
 
	int size()
	{
		return Q.size();
		
	}
	
	ArrayList<Item> getList()
	{
			return Q;
	}
	
}

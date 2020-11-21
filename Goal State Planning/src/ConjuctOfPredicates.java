import java.util.ArrayList;
import java.util.Iterator;


public class ConjuctOfPredicates implements IStackObject
{

	int _cid=7001;
	ArrayList<predicate> al=new ArrayList<predicate> ();
	
	public int getId() 
	{
		
		return _cid;
	}
	public ConjuctOfPredicates(ArrayList<predicate> al1)
		{
		
			Iterator i=al1.iterator();
			while(i.hasNext())
			{
				al.add((predicate) i.next());
			}
			
		}
	 public ConjuctOfPredicates()
		{
		
		}
	 
	 
}

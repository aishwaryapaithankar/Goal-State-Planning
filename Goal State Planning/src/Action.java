import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;


abstract class Action implements IStackObject
{
	int _aid; //Actions greater 8000
	ArrayList <predicate>preConditions= new ArrayList<predicate> ();
	ArrayList <predicate>positive= new ArrayList<predicate> ();
	ArrayList <predicate>negative= new ArrayList<predicate> ();
	
	public int getId()
	{
		return _aid;
	}
	abstract public String toString();
	
	
	static Action getAction(State s,predicate p)
	{
		if(p._pid==101 )  //OnXY
		{	
			return new StackXYAction(p._x,p._y);			
		}
		else if(p._pid==102 ) ///Holding X
		{
			Iterator i=s.state.iterator();
			while(i.hasNext())
			{
				predicate temp=(predicate)i.next();
				if(temp._pid== 101 && temp._x==p._x)
				{
					return new UnstackXYAction(p._x,temp._y);
				}
				else if(temp._pid== 104 && temp._x==p._x)
				{
					//return pickup action
					return new PickUpXAction(p._x);
				}
			}
		}
		else if(p._pid==103 )  //ClearX
		{	
			Iterator i=s.state.iterator();
			while(i.hasNext())
			{
				predicate temp=(predicate)i.next();
				if(temp._pid== 101 && temp._y==p._x)
				{
					return new UnstackXYAction(temp._x,p._x);
				}				
			}			
		}
		else if(p._pid==104 )  //OnTX
		{	
			return new PutDownXAction(p._x);			
		}
		else if(p._pid==105 )  //ArmEmpty
		{	
			//return new StackXYAction(p._x,p._y);		
			return new PutDownXAction(p._x);
		}
		
		
		
		
		return null;
	}
	
	
	
	
	
	boolean hasPositiveEffect(int p_id)
	{
		Iterator i=positive.iterator();
		while(i.hasNext())
		{
			if(((predicate)i.next())._pid==p_id)
			{
				return true;
			}
		}
		return false;
	}
	
		
	
}

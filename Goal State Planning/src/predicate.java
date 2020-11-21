import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;


public class predicate implements IStackObject
{
	/*101-oXY
	 * 102-hX
	 * 103-cX
	 * 104-otX
	 * 105-AE
	 */
	int _pid;
	int _x,_y;
	static Dictionary<String,predicate> d=new Hashtable<String,predicate> ();
	private predicate(int pid,int x,int y)
	{
		_pid=pid;
		if(pid==101)
		{
			_x=x;
			_y=y;
		}
		else 
		{
			if(pid!=105)
			{
				_x=x;
			}
		
		}
	}
	public static predicate createPredicate(int id,int x,int y)
	{
		StringBuffer key=new StringBuffer();
		key.append(id);
		if(id==101)
		{
			key.append(x);
			key.append(y);
		}
		else 
		{
			if(id!=105)
			{
				key.append(x);
			}
		
		}
		predicate p;
		if(d.get(key.toString())==null)
		{
			p=new predicate(id,x,y);
			d.put(key.toString(),p);
			return p;
		}
		else
			return d.get(key.toString());
		
	}
	public int getId() 
	{
		return _pid;
		
	}
	
	
	public boolean compare(predicate p)
	{
		boolean match = false;
		if(_pid==105)
		{
			match = (p.getId() == 105)?true:false;
		}
		else if(_pid==101)
		{
			if((p.getId() == 101)&& ( _x==p._x  )&& (_y==p._y)  )
			{
				match = true;
			}
		}
		else			
		{
			if((p.getId() == _pid)&& ( _x==p._x  ) )
			{
				match = true;
			}
			
		}
		return match;
		
	}
}

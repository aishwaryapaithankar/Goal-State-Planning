import java.util.ArrayList;
import java.util.Iterator;


public class State 
{
	ArrayList <predicate>state= new ArrayList<predicate> ();
	
	
	State(ConjuctOfPredicates c)
	{
		Iterator i=c.al.iterator();
		while(i.hasNext())
		{
			state.add((predicate) i.next());
		}
	}
	public boolean satisfies(ArrayList<predicate> goalPredicate)
	{
		boolean matchinner = false;
		Iterator<predicate> itrg=goalPredicate.iterator();
		while(itrg.hasNext())
		{
			matchinner = false;
			predicate temp=itrg.next();
			Iterator<predicate> itrs=state.iterator();
			while(itrs.hasNext())
			{
				if(temp.compare(itrs.next()))
				{
					matchinner = true;
					break;
				}
			}
			if(!matchinner){ break;}
		}
		
		return matchinner;
		
	}
	
	
	
	public boolean satisfies(predicate goalPredicate)
	{
		boolean matchinner = false;
			Iterator<predicate> itrs=state.iterator();
			while(itrs.hasNext())
			{
				if(goalPredicate.compare(itrs.next()))
				{
					matchinner = true;
					break;
				}
			}
		
		return matchinner;
		
	}
	
	
	
	
	
	public void Progress(Action a)
	{
		boolean matchinner = false;
		
		Iterator<predicate> itra=a.preConditions.iterator();
		while(itra.hasNext())
		{
			matchinner = false;
			predicate temp=itra.next();
			Iterator<predicate> itrs=state.iterator();
			while(itrs.hasNext())
			{
				if(temp.compare(itrs.next()))
				{
					matchinner = true;
					break;
				}
			}
			if(!matchinner){ break;}
		}
		
		if(matchinner)
		{
			//Delete the delete list
			
			itra=a.negative.iterator();
			while(itra.hasNext())
			{				
				predicate temp=itra.next();
				Iterator<predicate> itrs=state.iterator();
				while(itrs.hasNext())
				{
					if(temp.compare(itrs.next()))
					{
						itrs.remove();
						break;
					}
				}				
			}
			
			
			//Add the add list
			
			itra=a.positive.iterator();
			while(itra.hasNext())
			{	
				matchinner=false;
				Iterator<predicate> itrs=state.iterator();
				predicate p1=itra.next();
				while(itrs.hasNext())
				{
					if(p1.compare(itrs.next()))
					{
						matchinner=true;
						break;
					}
				}
				if(!matchinner)
				{
					state.add(p1);
				}
			}
			
		}
		
		
	}
	
	
	
	
	
	
}

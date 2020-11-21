import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;



public class Main   {

	public static void main(String[] args) 
	{
		Stack<IStackObject> obj= new Stack<IStackObject> ();
		ArrayList <Action> plan=new ArrayList <Action>();
/*		
////////////////////TEST CASE 1	
		// initial state
		predicate p=predicate.createPredicate(101, 1, 2);
		predicate clr=predicate.createPredicate(103, 1, -1);
		//predicate ontable=predicate.createPredicate(104, 2, -1);
		predicate ae=predicate.createPredicate(105, -1, -1);
		
		
		ConjuctOfPredicates cop = new ConjuctOfPredicates();
		cop.al.add(p);
		cop.al.add(clr);
		cop.al.add(ae);
		
		//creating start state out of the cop
		State start=new State(cop);
			
		//goal state
		
		predicate hold=predicate.createPredicate(102, 1, -1);
		
		ConjuctOfPredicates goal = new ConjuctOfPredicates();

		goal.al.add(hold);		
		
		obj.push(goal);
		obj.push(hold);		
////////////////////END TEST CASE 1 */
		
		
		
////////////////////TEST CASE 2	
/*	start state	
on table 1
on table 3
on table 4
on  2,1
clr 2
clr 3 
clr 4
ae
*/
	

// initial state
predicate ot1=predicate.createPredicate(104, 1, -1);	
predicate ot3=predicate.createPredicate(104, 3, -1);
predicate ot4=predicate.createPredicate(104, 4, -1);
predicate o21=predicate.createPredicate(101, 2, 1);
predicate clr2=predicate.createPredicate(103, 2, -1);
predicate clr3=predicate.createPredicate(103, 3, -1);
predicate clr4=predicate.createPredicate(103, 4, -1);
predicate ae=predicate.createPredicate(105, -1, -1);


ConjuctOfPredicates cop = new ConjuctOfPredicates();
cop.al.add(ot1);
cop.al.add(ot3);
cop.al.add(ot4);
cop.al.add(clr2);
cop.al.add(clr3);
cop.al.add(clr4);
cop.al.add(ae);
cop.al.add(o21);
//creating start state out of the cop
State start=new State(cop);

//goal state

/*goal state
 * on table 1
 * on table 4
 * on 3,1
 * on 2,4
 * clr 3
 * clr 2
 * ae
 */

predicate otg1=predicate.createPredicate(104, 1, -1);
predicate otg4=predicate.createPredicate(104, 4, -1);
predicate o31=predicate.createPredicate(101, 3, 1);
predicate o24=predicate.createPredicate(101, 2, 4);
predicate clrg2=predicate.createPredicate(103, 2, -1);
predicate clrg3=predicate.createPredicate(103, 3, -1);
predicate aeg=predicate.createPredicate(105, -1, -1);


ConjuctOfPredicates goal = new ConjuctOfPredicates();

goal.al.add(otg1);
goal.al.add(otg4);
goal.al.add(o31);
goal.al.add(o24);
goal.al.add(clrg2);
goal.al.add(clrg3);
goal.al.add(aeg);	

//Push conjunct of predicates pf the goal state
obj.push(goal);

//Push individual predicates pf the goal state

obj.push(otg1);
obj.push(otg4);
obj.push(o31);
obj.push(o24);
obj.push(clrg2);
obj.push(clrg3);
obj.push(aeg);
	

////////////////////END TEST CASE 2
		

		
		//GSP starts here		
		while(!obj.isEmpty())
		{
			IStackObject iso = obj.pop();
				int id = iso.getId();
				
				System.out.println(id);
			if(id == 7001) //Conjunct of predicates
			{
				
				if(!start.satisfies(((ConjuctOfPredicates)iso).al))
				{
					obj.push(((ConjuctOfPredicates)iso));
					
					Iterator i=((ConjuctOfPredicates)iso).al.iterator();
					while(i.hasNext())
					{
						obj.push((predicate)i.next());
					}
					
				}
				
			}
			else if(id >=101 && id <= 105) //Predicate
			{
				
				if(!start.satisfies((predicate)iso))
				{
					Action a=Action.getAction(start, (predicate)iso);
					if(null != a)
					{
						obj.push(a);
						obj.push(new ConjuctOfPredicates(a.preConditions));
						Iterator i=a.preConditions.iterator();
						while(i.hasNext())
						{
							obj.push((predicate) i.next());
						}					
					}
				}
				
				
			}
			else if(id > 8000)  //Action
			{
				plan.add((Action) iso);	
				start.Progress((Action) iso);
				
			}		
			
		}
		
		
		
		
		//GSP ends here. printing the plan
		System.out.println("GSP PLAN :");
		Iterator op=plan.iterator();
		while(op.hasNext())
		{
			System.out.println(op.next().toString());
		}
		
	}

}

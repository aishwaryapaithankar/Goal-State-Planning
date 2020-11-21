
public class PutDownXAction extends Action{
	int _x;
	//preconditions
	
	public PutDownXAction(int x)
	{
		_x=x;
		_aid = 8004;		
		
		predicate hX=predicate.createPredicate(102,x, -1);
		preConditions.add(hX);
	
		predicate ae=predicate.createPredicate(105,-1,-1);
		positive.add(ae);
		
		predicate onTX=predicate.createPredicate(104,x,-1);
		positive.add(onTX);
					
		negative.add(hX);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PutDown "+_x;
	}
}

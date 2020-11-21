
public class PickUpXAction extends Action{
	int _x;

	//preconditions
	
	public PickUpXAction(int x)
	{
		_x=x;
		_aid = 8003;
		predicate ae=predicate.createPredicate(105,-1,-1);
		preConditions.add(ae);
		
		predicate cX=predicate.createPredicate(103,x,-1);
		preConditions.add(cX);
		
		predicate onTX=predicate.createPredicate(104,x,-1);
		preConditions.add(onTX);
			
		
		predicate hX=predicate.createPredicate(102,x, -1);
		positive.add(hX);
					
		negative.add(ae);
		negative.add(onTX);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pickup "+_x;
	}

}

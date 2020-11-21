
public class UnstackXYAction extends Action
{
	
	int _x;
	int _y;
	//preconditions
	
	public UnstackXYAction(int x,int y)
	{
		_x=x;
		_y=y;
		_aid = 8001;
		predicate ae=predicate.createPredicate(105,-1,-1);
		preConditions.add(ae);
		
		predicate cX=predicate.createPredicate(103,x,-1);
		preConditions.add(cX);
		
		predicate onXY=predicate.createPredicate(101,x,y);
		preConditions.add(onXY);
			
		
		predicate hX=predicate.createPredicate(102,x, -1);
		positive.add(hX);
		predicate cY=predicate.createPredicate(103, y, -1);
		positive.add(cY);
					
		negative.add(ae);
		negative.add(onXY);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Unstack "+_x+" "+_y;
	}

}


public class StackXYAction extends Action {

	int _x;
	int _y;
	//preconditions
	
	public StackXYAction(int x,int y)
	{
		_x=x;
		_y=y;
		_aid = 8002;		
		
		predicate hX=predicate.createPredicate(102,x, -1);
		preConditions.add(hX);
		
		predicate cY=predicate.createPredicate(103, y, -1);
		preConditions.add(cY);
		
		
		predicate ae=predicate.createPredicate(105,-1,-1);
		positive.add(ae);
		
		predicate onXY=predicate.createPredicate(101,x,y);
		positive.add(onXY);
			
		negative.add(cY);			
		negative.add(hX);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Stack "+_x+" "+_y;
	}

}

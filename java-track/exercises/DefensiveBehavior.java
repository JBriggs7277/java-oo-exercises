
public class DefensiveBehavior implements RobotBehavior {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doNextMove(AttackBot a, AttackBot b) {
		
		if(b.distanceFromOther(a) < 5)
		{
			a.attack(b, 20);
		}
		
	}

}

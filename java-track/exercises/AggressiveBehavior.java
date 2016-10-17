
public class AggressiveBehavior implements RobotBehavior{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doNextMove(AttackBot a, AttackBot b) {
	
		a.positionX = b.positionX - 1;
		a.attack(b, 20);
		
		
	}

}

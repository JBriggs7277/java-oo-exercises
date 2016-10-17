
public class AttackBot extends Robot {
	
	private int HP;
	
	public AttackBot(String name, int positionX, int positionY, int speed, int orientation, int HP)
	{
		
		super(name, positionX, positionY, speed, orientation);
		this.HP = HP;
		
	}
	
	public int getHP()
	{
		return this.HP;
	}
	
	public void attack(AttackBot other, int power)
	{
		other.HP -= power;
	}
	
	public void repair(int health)
	{
		this.HP += health;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

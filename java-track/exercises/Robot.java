
public class Robot {

	//Fields:
	
	//Name - String
	private String name;
	//Positions - int
	private int positionX;
	private int positionY;
	//Speed - int
	private int speed;
	//Orientation - int 0, 90, 180, 270
	private int orientation;
	
	//Behaviors:
	
	//Create a Robot
	public Robot(String name, int positionX, int positionY, int speed, int orientation)
	{
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
		this.speed = speed;
		this.orientation = orientation;
	}
	
	//Get the name
	public String getName()
	{
		return this.name;
	}
	
	//Get the positions
	public int getPositionX()
	{
		return this.positionX;
	}
	
	public int getPositionY()
	{
		return this.positionY;
	}
	
	//Get the speed
	public int getSpeed()
	{
		return this.speed;
	}
	
	//Get the orientation
	public int getOrientation()
	{
		return this.orientation;
	}
	
	//Movement
	public void moveRobot(int movement)
	{
		if (this.orientation == 0) {
			this.positionX = this.positionX - (this.speed * movement);
		} else if (this.orientation == 90) {
			this.positionY = this.positionY + (this.speed * movement);
		} else if (this.orientation == 180) {
			this.positionX = this.positionX + (this.speed * movement);
		} else if (this.orientation == 270) {
			this.positionY = this.positionY - (this.speed * movement);
		}
	}
	
	//Rotation
	public void rotateRobot(int direction)
	{
		this.orientation = this.orientation + direction;
	}
	
	//Distance from other Robot
	public String distanceFromOther(Robot robot)
	{
		int diffX = this.positionX - robot.positionX;
		int diffY = this.positionY - robot.positionY;
		
		return "I am " + diffX + " away from X and " + diffY + " away from Y.";
	}
	
	//ToString
	public String toString() 
	{
		return "Name: " + this.name + " Position: (" + this.positionX + ", " + this.positionY + ") Speed: " + this.speed + " Orientation: " + this.orientation;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot myRobot = new Robot("Alfred", -5, 10, 3, 180);
		Robot yourRobot = new Robot("Jeeves", 11, -2, 5, 90);
		myRobot.moveRobot(5);
		System.out.println(myRobot);
		System.out.println(myRobot.distanceFromOther(yourRobot));
	}

}

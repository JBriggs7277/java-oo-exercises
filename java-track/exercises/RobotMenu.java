import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	
	private ArrayList<Robot> robots;
	private Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		} while (x != 6);
	}
	
	public RobotMenu()
	{
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	public int startMenu()
	{
		System.out.println("Welcome to the robot menu!");
		System.out.println("1. Create a robot");
		System.out.println("2. Display a list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Compute the distance between two robots");
		System.out.println("6. Exit");
		System.out.println("Please select an option: ");
		int selection = s.nextInt();
		while(selection < 0 || selection > 6)
		{
			System.out.println("Invalid selection, please try again: ");
			selection = s.nextInt();
		}
		return selection;
	}
	
	public void processInput(int selection)
	{
		if(selection == 1)
		{
			createRobot();
		}
		else if(selection == 2)
		{
			displayRobots();
		}
		else if(selection == 3)
		{
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Please enter how many spaces you want to move the robot");
			int proc = s.nextInt();
			r.moveRobot(proc);
			System.out.println("Here is the robot's status after it moved: ");
			System.out.println(r);
		}
		else if(selection == 4)
		{
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Do you want to rotate the robot left or right?");
			String rotation = s.nextLine();
			int numRotate = 0;
			
			if(rotation != "left" || rotation != "right"){
				
				System.out.println("Invalid input.  Please type either left or right");
				rotation = s.nextLine();
			} else if(rotation == "left") {
				numRotate = -90;
			} else if(rotation == "right") {
				numRotate = 90;
			}
			
			r.rotateRobot(numRotate);
			System.out.println("Here is the robot's status after rotation: ");
			System.out.println(r);
				
		}
		
		else if(selection == 5)
		{
			displayRobots();
			Robot r = selectRobot();
			Robot s = selectRobot();
			System.out.println("The distance between the two Robots you selected is: " + r.distanceFromOther(s));
			
		}
	}
	
	private void displayRobots()
	{
		for(int i = 0; i < robots.size(); i++)
		{
			System.out.println((i+1) + ".)" + robots.get(i));
		}
	}
	
	private Robot selectRobot() {
		System.out.println("Please select a Robot: ");
		int selection = s.nextInt();
		while(selection < 1 || selection > robots.size())
		{
			System.out.println("Invalid selection, please try again: ");
			selection = s.nextInt();
		}
		return robots.get(selection - 1);
	}
	
	private void createRobot()
	{
		System.out.println("Please enter a name for the robot: ");
		String name = s.next();
		System.out.println("Please enter an x position for the robot: ");
		int positionX = s.nextInt();
		System.out.println("Please enter a y position for the robot: ");
		int positionY = s.nextInt();
		System.out.println("Please enter a speed for the robot: ");
		int speed = s.nextInt();
		while(speed < 1)
		{
			System.out.println("Invalid value.  Please enter a positive value: ");
			speed = s.nextInt();
		}
		System.out.println("Please enter an orientation for the robot (west = 0, north = 90, east = 180, south = 270: ");
		int orientation = s.nextInt();
		if(orientation == 0 || orientation == 90 || orientation == 180 || orientation == 270)
		{
			robots.add(new Robot(name, positionX, positionY, speed, orientation));
		}
		
		else {
			System.out.println("Invalid value.  Please select 0 for west, 90 for north, 180 for east, or 270 for south: ");
			orientation = s.nextInt();
		}
		
	}
}

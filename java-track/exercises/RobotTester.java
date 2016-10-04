import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTester {

	@Test
	public void testMoveRobot() {
		Robot r = new Robot("Jeeves", 5, 5, 3, 0);
		assertTrue("Problem setting the position of x", r.getPositionX() == 5);
		r.moveRobot(3);
		assertTrue("Problem moving the robot successfully", r.getPositionX() == -4);
	}

	@Test
	public void testRotateRobot() {
		Robot r = new Robot("Jeeves", 5, 5, 3, 90);
		assertTrue("Problem setting the orientation", r.getOrientation() == 90);
		r.rotateRobot(90);
		assertTrue("Problem rotating the robot successfully", r.getOrientation() == 180);
	}
	
	@Test
	public void testDistanceFromOther() {
		Robot r = new Robot("Jeeves", 15, 20, 3, 0);
		Robot s = new Robot("Alfred", 2, 5, 2, 90);
		assertTrue("Problem calculating the distance", r.distanceFromOther(s) == 19.849433241279208);
	}
}

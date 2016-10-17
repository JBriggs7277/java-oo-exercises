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
	
	@Test
	public void testGetHP() 
	{
		AttackBot r = new AttackBot("Sid", 10, 20, 7, 90, 100);
		assertEquals("Problem getting HP.", 100, r.getHP());
	}
	
	@Test
	public void testAttack()
	{
		AttackBot r = new AttackBot("Sid", 10, 20, 7, 90, 100);
		AttackBot s = new AttackBot("Psycho", 10, 20, 4, 0, 100);
		r.attack(s, 10);
		assertEquals("Problem calculating HP after attack.", 90, s.getHP());
	}
	
	@Test
	public void testRepair()
	{
		AttackBot s = new AttackBot("Psycho", 10, 20, 4, 0, 80);
		s.repair(20);
		assertEquals("Problem calculating HP after repair.", 100, s.getHP());
		
	}
	
	@Test
	public void testRoombaGetters()
	{
		RoombaBot r = new RoombaBot("Jeeves", 10, 20, 5, 180, 60);
		assertEquals("Problem getting the Max Cap", 60, r.getMaxCap());
		assertEquals("Problem getting the current amount of dirt", 0, r.getDirt());
		assertEquals("Problem knowing if the bag is full", false, r.isBagFull());
	}
	
	@Test
	public void testVacuum()
	{
		RoombaBot r = new RoombaBot("Jeeves", 10, 20, 5, 180, 60);
		r.vacuum(30);
		assertEquals("Problem adding dirt.", 30, r.getDirt());
		r.vacuum(30);
		assertEquals("Problem making bag full.", true, r.isBagFull());
	}
	
	@Test
	public void testDeliveryBot()
	{
		DeliveryBot r = new DeliveryBot("Alfred", 10, 20, 10, 0);
		assertEquals("Problem initializing package", "", r.getCurrentPackage());
		assertEquals("Problem initializing hasOrder", false, r.doesHaveOrder());
		r.getOrder("Baby Crib");
		assertEquals("Problem adding package", "Baby Crib", r.getCurrentPackage());
		assertEquals("Problem changing hasOrder", true, r.doesHaveOrder());
		r.deliverPackage(30, -10);
		assertEquals("Problem setting x", 30, r.getPositionX());
		assertEquals("Problem setting y", -10, r.getPositionY());
		assertEquals("Problem changing hasOrder", false, r.doesHaveOrder());
		assertEquals("Problem removing package", "", r.getCurrentPackage());
	}
}

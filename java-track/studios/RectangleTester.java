import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTester {

	@Test
	public void testGetters() {
		Rectangle r = new Rectangle(5, 10);
		assertEquals("Problem getting the correct length.", 5, r.getLength());
		assertEquals("Problem getting the correct width.", 10, r.getWidth());
	}
	
	@Test
	public void testArea() {
		Rectangle r = new Rectangle(5, 5);
		assertEquals("Problem calculating the area.", 25, r.area());
	}
	
	@Test
	public void testPerimeter() {
		Rectangle r = new Rectangle(5, 5);
		assertEquals("Problem calculating the perimeter", 20, r.perimeter());
	}
	
	@Test
	public void testIsItSmaller() {
		Rectangle r = new Rectangle(5, 5);
		Rectangle s = new Rectangle(10, 10);
		assertTrue("Problem determining if it's smaller.", r.isItSmaller(s));
		assertFalse("Problem determining if it's smaller.", s.isItSmaller(r));
	}
	
	@Test
	public void testIsItSquare() {
		Rectangle r = new Rectangle(5, 5);
		Rectangle s = new Rectangle(5, 10);
		assertTrue("Problem determining if it's a square.", r.isItSquare());
		assertFalse("Problem determining if it's a square.", s.isItSquare());
	}

}

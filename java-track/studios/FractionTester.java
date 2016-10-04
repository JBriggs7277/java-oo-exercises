import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTester {

	@Test
	public void testGetters() {
		Fraction f = new Fraction(2, 4);
		assertEquals("Problem getting numerator.", 2, f.getNum());
		assertEquals("Problem getting denomenator.", 4, f.getDenom());
	}
	
	@Test
	public void testAddFraction() {
		Fraction f = new Fraction(1, 2);
		Fraction g = new Fraction(1, 3);
		Fraction h = new Fraction(1, 3);
		assertEquals("Problem adding fractions.", "5/6", f.addFraction(g));
		assertEquals("Problem adding fractions.", "2/3", g.addFraction(h));
	}
	
	@Test
	public void testMultFraction() {
		Fraction f = new Fraction(1,2);
		Fraction g = new Fraction(1,3);
		assertEquals("Problem multiplying fractions.", "1/6", f.multFraction(g));
	}
	
	@Test
	public void testGetRecip() {
		Fraction f = new Fraction(1, 2);
		assertEquals("Problem getting reciprocal.", "2/1", f.getRecip());
	}
	
	@Test
	public void testGcd() {
		Fraction f = new Fraction(15, 45);
		assertEquals("Problem getting common denominator.", 15, f.gcd());
	}
	
	@Test
	public void testSimplify() {
		Fraction f = new Fraction(140, 161);
		f.simplify();
		assertEquals("Problem simplifying the fraction.", 20, f.getNum());
		assertEquals("Problem simplifying the fraction.", 23, f.getDenom());
	}
}

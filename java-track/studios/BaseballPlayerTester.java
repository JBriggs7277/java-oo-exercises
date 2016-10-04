import static org.junit.Assert.*;

import org.junit.Test;

public class BaseballPlayerTester {

	@Test
	public void testGetters() {
		BaseballPlayer a = new BaseballPlayer("Jeremy Briggs", 27, "Right", 5, 7, 2);
		assertEquals("Problem getting Player's name.", "Jeremy Briggs", a.getName());
		assertEquals("Problem getting Jersey Number.", 27, a.getJersey());
		assertEquals("Problem getting Hit Orientation.", "Right", a.getOrient());
		assertEquals("Problem getting total runs.", 5, a.getRuns());
		assertEquals("Problem getting total RBIs.", 7, a.getRBIs());
		assertEquals("Problem getting total games", 2, a.getGames());
	}
	
	@Test
	public void testAddRun() {
		BaseballPlayer a = new BaseballPlayer("Jeremy Briggs", 27, "Right", 5, 7, 2);
		assertEquals("Problem adding runs to total.", 7, a.addRun(2));
	}
	
	@Test
	public void testAddRBI() {
		BaseballPlayer a = new BaseballPlayer("Jeremy Briggs", 27, "Right", 5, 7, 2);
		assertEquals("Problem adding RBIs to total.", 10, a.addRBI(3));
	}
	
	@Test
	public void testAddGame() {
		BaseballPlayer a = new BaseballPlayer("Jeremy Briggs", 27, "Right", 5, 7, 2);
		assertEquals("Problem adding game to total.", 3, a.addGame(1));
	}
	
	@Test
	public void testPlayGame() {
		BaseballPlayer a = new BaseballPlayer("Jeremy Briggs", 27, "Right", 5, 7, 2);
		a.playGame(3, 5);
		assertEquals("Problem adding stats from game played.", 8, a.getRuns());
		assertEquals("Problem adding stats from game played.", 12, a.getRBIs());
		assertEquals("Problem adding stats from game played.", 3, a.getGames());
	}

}

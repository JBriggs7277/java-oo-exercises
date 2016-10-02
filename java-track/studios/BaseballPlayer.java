
public class BaseballPlayer {
	//fields:
	
	//name - string
	private String name;
	//jersey number - int
	private int jerseyNum;
	//hit orientation - string - left, right, switch
	private String hitOrientation;
	//total runs - int
	private int totalRuns;
	//total rbis - int
	private int totalRBIs;
	//total games - int
	private int totalGames;
	
	//methods:
	
	//create player
	public BaseballPlayer(String name, int jerseyNum, String hitOrientation, int totalRuns, int totalRBIs, int totalGames)
	{
		this.name = name;
		this.jerseyNum = jerseyNum;
		this.hitOrientation = hitOrientation;
		this.totalRuns = totalRuns;
		this.totalRBIs = totalRBIs;
		this.totalGames = totalGames;
		
	}
	
	//get name
	public String getName() {
		return this.name;
	}
	
	//get jersey
	public int getJersey() {
		return this.jerseyNum;
	}
	
	//get hit orient
	public String getOrient() {
		return this.hitOrientation;
	}
	
	//get total runs
	public int getRuns() {
		return this.totalRuns;
	}
	
	//get total rbis
	public int getRBIs() {
		return this.totalRBIs;
	}
	
	//get total games
	public int getGames() {
		return this.totalGames;
	}
	
	//add run
	public int addRun(int runs) {
		this.totalRuns += runs;
		return this.totalRuns;
	}
	
	//add rbi
	public int addRBI(int rbi) {
		this.totalRBIs += rbi;
		return this.totalRBIs;
	}
	
	//add game
	public int addGame(int game) {
		this.totalGames += game;
		return this.totalGames;
	}
	
	//play game
	public void playGame(int runs, int rbi) {
		this.addGame(1);
		this.addRBI(rbi);
		this.addRun(runs);
	}
	
	//toString
	public String toString() {
		return "Name: " + this.name + " Jersey number: " + this.jerseyNum + " Hit Orientation: " + this.hitOrientation + " Games Played: " + this.totalGames + " Total Runs: " + this.totalRuns + " Total RBIs: " + this.totalRBIs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseballPlayer player1 = new BaseballPlayer("Jeremy", 27, "Right", 0, 0, 0);
		System.out.println(player1);
		player1.playGame(3, 4);
		System.out.println(player1);
		player1.playGame(1, 2);
		System.out.println(player1);
	}

}

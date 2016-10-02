
public class Fraction {
	
	//Fields:
	
	//Numerator 
	private int num;
	//Denomenator
	private int denom;
	
	//Behaviors:
	
	//Create Fraction
	public Fraction(int num, int denom) {
		this.num = num;
		this.denom = denom;
	}
	//Get Numerator
	public int getNum() {
		return this.num;
	}
	
	//Get Denomenator
	public int getDenom() {
		return this.denom;
	}
	
	//Add Fraction
	public String addFraction(Fraction other) {
		if(this.denom != other.denom) {
			int thisnum = this.num * other.denom;
			int thisdenom = this.denom * other.denom;
			int otherdenom = other.denom * this.denom;
			int othernum = other.num * this.denom;
			
			this.num = thisnum + othernum;
			this.denom = thisdenom;
			this.simplify();
		}
		else {
			this.num = this.num + other.num;
			this.simplify();
		}
		return this.toString();
	}
	
	//Multiply Fraction
	public String multFraction(Fraction other) {
		this.simplify();
		other.simplify();
		this.num = this.num * other.num;
		this.denom = this.denom * other.denom;
		
		this.simplify();
		return this.toString();
	}
	
	//Reciprocal
	public String getRecip() {
		int newnum = this.denom;
		int newdenom = this.num;
		
		this.num = newnum;
		this.denom = newdenom;
		
		return this.toString();
	}
	
	//Find the GCD 
	public int gcd() {
		int num = this.num;
		int denom = this.denom;
		
		while(denom != 0) {
			int oldnum = num;
			int olddenom = denom;
			
			denom = oldnum % olddenom;
			num = olddenom;
		}
		return num;
	}
	
	//Simplify
	public void simplify() {
		int gcd = this.gcd();
		
		this.num = this.num / gcd;
		this.denom = this.denom / gcd;		
	}
	
	//ToString
	public String toString() {
		return this.num + "/" + this.denom;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction fract1 = new Fraction(1, 5);
		Fraction fract2 = new Fraction(2, 3);
		System.out.println(fract1.gcd());
		fract1.simplify();
		System.out.println(fract1.getRecip());
		System.out.println(fract1.multFraction(fract2));
	}

}

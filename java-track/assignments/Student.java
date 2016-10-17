

public class Student {
	//fields:
	
	//First name
	private String firstName;
	//Last name
	private String lastName;
	//Student Id
	private int studentID;
	//Credits
	private int credits;
	//GPA
	private double gpa;
	
	//Methods:
	
	//Create a Student
	public Student(String firstName, String lastName, int studentID)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
	}
	//Get First and Last Name
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	//Get Student Id
	public int getStudentID() {
		return this.studentID;
	}
	
	//Get Credits
	public int getCredits() {
		return this.credits;
	}
	
	//Get Class Standing
	public String getClassStanding() {
		if(this.credits < 30) {
			return "Freshman";
		} else if(this.credits >= 30 && this.credits < 60) {
			return "Sophomore";
		} else if(this.credits >= 60 && this.credits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	//Get Total GPA
	public double getGPA() {
		return this.gpa;
	}
	
	//Submit Grade
	public void submitGrade(double grade, int credits) {
		double qualityScore = (grade * credits);
		//Undo the gpa to get the sum of quality scores
		this.gpa = (this.gpa * this.credits);
		//Update credits
		this.credits += credits;
		//Add quality score to total sum, then convert to gpa
		this.gpa = (this.gpa + qualityScore) / this.credits;
		//Round to 3 decimal places
		this.gpa = Math.round(this.gpa * 1000.0) / 1000.0;
				
	}
	
	//Compute Tuition
	public double computeTuition() {
		int semTotal = (int) this.credits / 15;
		int partialSem = this.credits % 15;
		double tuition = (20000.00 * semTotal) + (1333.33 * partialSem);
		//uncomment the next line if you want 2 decimal places for monetary purposes
		//tuition = Math.round(tuition * 100.0) / 100.0;
		return tuition;
	}
	
	//Create Legacy
	public static Student createLegacy(Student s1, Student s2) {
		String dadName = s1.getName();
		String momName = s2.getName();
		int babyID = s1.getStudentID() + s2.getStudentID();
		Student legacy = new Student(dadName, momName, babyID);
		legacy.gpa = (s1.getGPA() + s2.getGPA()) / 2;
		legacy.credits = Math.max(s1.getCredits(), s2.getCredits());
		return legacy;
	}
	
	//toString
	public String toString() {
		return "Name: " + this.getName() + " ID: " + this.studentID;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

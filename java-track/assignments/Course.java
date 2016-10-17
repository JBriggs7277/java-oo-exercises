import java.util.ArrayList;

public class Course {
	//fields:
	
	//Name
	private String name;
	//Credits
	private int credits;
	//Number of seats remaining
	private int remainingSeats;
	//Roster of Students
	private Student[] studentRoster;
	
	
	//methods:
	
	//Create a Course
	public Course(String name, int credits, int remainingSeats)
	{
		this.name = name;
		this.credits = credits;
		this.remainingSeats = remainingSeats;
		this.studentRoster = new Student[remainingSeats];
	}
	
	//get name
	public String getName() {
		return this.name;
	}
	
	//get credits
	public int getCredits() {
		return this.credits;
	}
	
	//get number of seats remaining
	public int getRemainingSeats() {
		return this.remainingSeats;
	}
	
	//add student
	public boolean addStudent(Student student) {
		
		if (this.remainingSeats == 0) {
			return false;
		} else {
			for (int i = 0; i < this.studentRoster.length; i++) {
				if(studentRoster[i] instanceof Student) {
					if(student.getName() == studentRoster[i].getName()) {
						return false;
					}
				}
				 else {
						studentRoster[this.remainingSeats - 1] = student;
						this.remainingSeats -= 1;
						return true;
				 }
			}
		} return false;
	} 
	
	//generate roster
	public String generateRoster() 
	{
		String roster = "";
		for(int i = 0; i < this.studentRoster.length; i++) 
		{
			if(studentRoster[i] instanceof Student) 
			{
				 roster += "Student Name: " + studentRoster[i].getName() + " ID: " + studentRoster[i].getStudentID();
			}
		}
		return roster;
	}
	
	
	//average GPA
	public double averageGPA()
	{
		double totalGPA = 0;
		double totalStudents = 0;
		for(int i = 0; i < this.studentRoster.length; i++)
		{
			if(studentRoster[i] instanceof Student)
			{
				totalGPA += studentRoster[i].getGPA();
				totalStudents += 1;
			}
		}
		double avgGPA = totalGPA / totalStudents;
		return avgGPA;
	}
		
	
	//toString
	public String toString()
	{
		return "Course: " + this.getName() + " Credits: " + this.getCredits();
	}
	
	//static arrayList for viewing all Courses
	public static  ArrayList<Course> getAllCourses()
	{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

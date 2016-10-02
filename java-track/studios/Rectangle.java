
public class Rectangle {
	
	//fields:
	
	//length
	private int length;
	//width
	private int width;
	
	//behaviors:
	
	//Create a rectangle
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	//Get the length
	public int getLength() {
		return this.length;
	}
	
	//Get the width
	public int getWidth() {
		return this.width;
	}
	
	//Calculate the area
	public int area() {
		return this.length * this.width;
	}
	
	//Calculate the perimeter
	public int perimeter() {
		return (this.length * 2) + (this.width * 2);
	}
	
	//Is it smaller?
	public boolean isItSmaller(Rectangle other) {
		return this.area() < other.area();
	}
	
	//Is it a square
	public boolean isItSquare() {
		return this.length == this.width;
	}
	
	//ToString
	public String toString() {
		return "Length: " + this.length + " Width: " + this.width + " Area: " + this.area() + " Perimeter: " + this.perimeter();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect1 = new Rectangle(10, 10);
		Rectangle rect2 = new Rectangle(35, 20);
		System.out.println(rect1);
		System.out.println(rect1.isItSmaller(rect2));
		System.out.println(rect1.isItSquare());
	}

}

package prob6;

public class Rectangle extends Shape implements Resizable {
	static double width;
	static double height;
	
	public void resize(double r) {
		width = width * r;
		height = height * r;
	}

	public Rectangle(int i, int j) {
		// TODO Auto-generated constructor stub
		width = i;
		height = j;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (width+height)*2;
	}

}

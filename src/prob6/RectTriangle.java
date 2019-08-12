package prob6;
import java.math.*;

public class RectTriangle extends Shape {
	private double width;
	private double height;

	public RectTriangle(int i, int j) {
		// TODO Auto-generated constructor stub
		width = i;
		height = j;

	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height / 2;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return width + height + Math.sqrt(width*width + height*height);
	}

}

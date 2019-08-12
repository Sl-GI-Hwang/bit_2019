package prob6;

public interface Resizable {
	
	public static void resize(double r) {
		Rectangle.width = Rectangle.width *r;
		Rectangle.height = Rectangle.height *r;
	}
}

package paint;

public class Main {

	public static void main(String[] args) {
		Point p1 = new Point();
		p1.setX(10);
		p1.setY(20);
		
		drawPoint(p1);
		p1.show(false);
		
		Point p2 = new Point(100, 200);
		drawPoint(p2);
		
		Point cp1 = new ColorPoint();
		cp1.setX(300);
		cp1.setY(200);
		((ColorPoint)cp1).setColor("yellow");
		drawPoint(cp1);
	}

	public static void drawPoint(Point point) {
		point.show();
	}
	
//	public static void drawColorPoint(ColorPoint point) {
//		point.show();
//	}
	
}

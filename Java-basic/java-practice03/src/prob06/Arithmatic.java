package prob06;

public abstract class Arithmatic {
	int a;
	int b;
	public Arithmatic(int a, int b) {
		setValue(a,b);
	}
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a;		
	}
}

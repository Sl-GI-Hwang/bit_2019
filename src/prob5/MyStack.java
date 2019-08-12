package prob5;

public class MyStack {
	private int top = -1;
	private String[] buffer;
	private int stackSize;
	
	public MyStack(int i) {
		// TODO Auto-generated constructor stub
    	stackSize = i;
    	buffer = new String[stackSize];
    }
    
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == -1);
	}
	public String pop() throws MyStackException {
		// TODO Auto-generated method stub
		if(top < 0) {
			throw new MyStackException();
		}
		return buffer[top--];
	}

	public void push(String string) {
		// TODO Auto-generated method stub
		if(top >= stackSize-1) {
			String[] buf = buffer;
			stackSize *= 2;
			buffer = new String[stackSize];
			for(int i = 0; i < buf.length; i++) {
				buffer[i] = buf[i];	
			}	
		}
		buffer[++top] = string;
	}

	
}
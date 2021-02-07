package chapter02;

import chapter02.Customer;

public class CustomerApp {

	public static void main(String[] args) {
		Customer c = new Customer();
		
		// protected 는 같은 패키지에서 접근 O
		c.name = "둘리";
		
		// private은 외부에서 접근 X
		// c.age = 10;
		c.setAge(10);
	}

}

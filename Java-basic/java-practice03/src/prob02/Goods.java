package prob02;

public class Goods {
	private String name;
	private int price;
	private int number;
	
	Goods(String name, int price, int number) {
		this.name = name;
		this.price = price;
		this.number = number;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(name+"(가격:"+price+"원)이 "+number+"개 입고 되었습니다.");
	}
}

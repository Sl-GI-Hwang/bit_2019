package chapter02;

public class Goods {
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public static int countOfGoods;
	
	
	public Goods() {
		// Goods.countOfGoods++;
		// Goods.countOfGoods += 1;
		countOfGoods += 1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		System.out.println(name + ":" + price + ":" + countStock + ":" + countSold );
	}

	public int calcDiscountPrice(float discountRate) {
		return price - (int)(price * discountRate);
	}
}

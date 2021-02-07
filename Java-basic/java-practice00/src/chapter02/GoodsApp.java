package chapter02;

public class GoodsApp {
	
	public static void main(String[] args) {
		Goods camera = new Goods();
		camera.setName("nikon");
		//camera.price = -1;
		camera.setPrice(25000);
		camera.setCountStock(30);
		camera.setCountSold(50);
		
		System.out.println(Goods.countOfGoods);
		
		camera.showInfo();
		System.out.println(camera.calcDiscountPrice(0.5f));
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		System.out.println(Goods.countOfGoods);
		
		
	}

}

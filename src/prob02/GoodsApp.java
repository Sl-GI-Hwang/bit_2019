package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Goods[] goods = new Goods[3];

		for(int i = 0; i < COUNT_GOODS; i++) {
			String item = scanner.next();
			int price = scanner.nextInt();
			int number = scanner.nextInt();
			
			goods[i] = new Goods(item, price, number);
		}
		
		for(int i = 0; i < 3; i++) {
			goods[i].print();
		}
		
		scanner.close();
	}
}

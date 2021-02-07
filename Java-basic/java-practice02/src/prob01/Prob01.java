package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
Scanner scanner = new Scanner( System.in  );
		
		System.out.print( "금액: " );
		int money = scanner.nextInt();
		int current = money;
		int cnt = 0;
		
		while(current > 50000) {
			cnt++;
			current -= 50000;
		}
		System.out.println("50000원 : " + cnt + "개");
		
		cnt = 0;
		while(current > 10000) {
			cnt++;
			current -= 10000;
		}
		System.out.println("10000원 : " + cnt + "개");
		
		cnt = 0;
		while(current > 5000) {
			cnt++;
			current -= 5000;
		}
		System.out.println("5000원 : " + cnt + "개");
		
		cnt = 0;
		while(current > 1000) {
			cnt++;
			current -= 1000;
		}
		System.out.println("1000원 : " + cnt + "개");

		cnt = 0;
		while(current > 500) {
			cnt++;
			current -= 500;
		}
		System.out.println("500원 : " + cnt + "개");
		
		cnt = 0;
		while(current > 100) {
			cnt++;
			current -= 100;
		}
		System.out.println("100원 : " + cnt + "개");
		
		cnt = 0;
		while(current > 50) {
			cnt++;
			current -= 50;
		}
		System.out.println("50원 : " + cnt + "개");
		
		cnt = 0;
		while(current > 10) {
			cnt++;
			current -= 10;
		}
		System.out.println("10원 : " + cnt + "개");
		
		cnt = 0;
		while(current > 5) {
			cnt++;
			current -= 5;
		}
		System.out.println("5원 : " + cnt + "개");
		
		cnt = 0;
		while(current > 0) {
			cnt++;
			current -= 1;
		}
		System.out.println("1원 : " + cnt + "개");
		
		scanner.close();
 	}
}
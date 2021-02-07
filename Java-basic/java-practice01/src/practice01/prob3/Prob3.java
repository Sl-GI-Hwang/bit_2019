package practice01.prob3;

import java.util.Scanner;

public class Prob3 {
	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int a = s.nextInt();
		int sum = 0;
		
		if(a % 2 == 0) {
			for(int i = 0; i <= a;) {
				sum += i;
				i = i + 2;
			}
		} else {
			for(int i = 1; i <= a;) {
				sum += i;
				i = i + 2;
			}
		}
		
		System.out.println("결과 값 :" + sum);
		
	}
}

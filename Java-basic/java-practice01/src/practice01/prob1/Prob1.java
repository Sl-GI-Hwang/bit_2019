package practice01.prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("수를 입력하시오 : ");
		int number = s.nextInt();
		
		if(number % 3 == 0) {
			System.out.println("3의 배수입니다.");
		}else {
			System.out.println("3의 배수가 아닙니다.");
		}
		s.close();
	}
}

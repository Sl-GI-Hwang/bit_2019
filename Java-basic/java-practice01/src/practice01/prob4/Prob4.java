package practice01.prob4;

import java.util.Scanner;

public class Prob4 {
	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("문자열을 입력하세요. : ");
		
		String name = s.next();
		for(int i = 0; i < name.length(); i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(name.substring(j, j+1));
			}
			System.out.println();
		}
		
	}
}

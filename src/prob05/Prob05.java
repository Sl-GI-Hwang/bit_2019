package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		int maxNumber = 100;
		int minNumber = 1;
		
		Scanner scanner = new Scanner( System.in );
		Random r = new Random();
		int k = r.nextInt(maxNumber) + minNumber;
		
		System.out.println("수를 결정하겠습니다. 맞추어 보세요");
		System.out.println(minNumber+"-"+maxNumber);
		
		int index = 1;
		int cur = 0;
		while(true) {
			System.out.print(index + ">>");
			cur = scanner.nextInt();
			if(cur > k) {
				System.out.println("더 낮게");
				if(cur < maxNumber) {
					maxNumber = cur;
				}
				System.out.println(minNumber+"-"+maxNumber);
			} else if(cur < k) {
				System.out.println("더 높게");
				if(cur > minNumber) {
					minNumber = cur;
				}
				System.out.println(minNumber+"-"+maxNumber);
			} else if(cur == k) {
				System.out.println("맞았습니다.");
				System.out.println("다시 하시겠습니까(y/n)");
				String c = scanner.next();
				if(c.equals("y")) {
					index = 1;
					minNumber = 1;
					maxNumber = 100;
					
					k = r.nextInt(maxNumber) + minNumber;
					continue;
				}
				else if(c.equals("n")) {
					break;
				} else {
					System.out.println("다시 입력해주세요.");
				}
			}
			index++;
		}
		scanner.close();
	}

}
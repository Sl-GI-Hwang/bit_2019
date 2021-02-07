package practice01.prob2;

public class Prob2 {
	public static void main (String args[]) {
		int a = 10;
		for(int i = 1; i <= a; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(i+j + " ");
			}
			a++;
			System.out.println();
			if(a > 18) break;
		}
	}
}

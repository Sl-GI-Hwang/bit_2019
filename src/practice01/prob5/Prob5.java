package practice01.prob5;

public class Prob5 {
	public static void main (String args[]) {
		
		int buff = 0;
		for(int i = 0; i < 100; i++) {
			buff = i % 10;
			if((i-buff == 30) || (i-buff == 60) || (i-buff == 90)) {
				System.out.print(i+" 짝");
				if((buff == 3) || (buff == 6) || (buff == 9)) {
					System.out.print("짝");
				}
				System.out.println();
			}
			if((buff == 3) || (buff == 6) || (buff == 9)) {
				System.out.println(i+" 짝");
			}
		}
		
		
		// String 변환후 처리
		/*
		for(int i = 0; i < 100; i++) {
			String s = String.valueOf(i);
			
			if(s.substring(0, 1).equals("3") || s.substring(0, 1).equals("6") || s.substring(0, 1).equals("9")) {
				System.out.print(i + " 짝");
				if(s.substring(1).equals("3") || s.substring(1).equals("6") || s.substring(1).equals("9")) {
					System.out.print("짝");
				}
				System.out.println();
			} else {
				if(s.substring(1).equals("3") || s.substring(1).equals("6") || s.substring(1).equals("9")) {
					System.out.print(i + " 짝");
					System.out.println();
				}
			}
		}
		*/
	}
}

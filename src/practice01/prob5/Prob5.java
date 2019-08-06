package practice01.prob5;

public class Prob5 {
	public static void main (String args[]) {
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
	}
}

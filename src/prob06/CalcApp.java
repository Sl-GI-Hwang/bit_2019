package prob06;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sign = 1;		
		
		
		while( true ) {

			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			/*  코드를 완성 합니다 */
			int first = Integer.parseInt(tokens[0]);
			int second = Integer.parseInt(tokens[2]);
			if(tokens[sign].equals("+")) {
				Add add = new Add();
				add.setValue(first, second);
				System.out.println(">> " + add.calculate());
			} else if(tokens[sign].equals("-")) {
				Sub sub = new Sub();
				sub.setValue(first, second);
				System.out.println(">> " + sub.calculate());
			} else if(tokens[sign].equals("*")) {
				Mul mul = new Mul();
				mul.setValue(first, second);
				System.out.println(">> " + mul.calculate());
			} else if(tokens[sign].equals("/")) {
				Div div = new Div();
				div.setValue(first, second);
				System.out.println(">> " + div.calculate());
			}
		
		}
		
		scanner.close();

	}

}

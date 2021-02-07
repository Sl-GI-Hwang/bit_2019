package prob03;

public class CurrencyConverter {
	private static double rate;
	private static double won;
	private static double dollar;

	public static void setRate(double rate) {
		// TODO Auto-generated method stub
		CurrencyConverter.rate = rate;
	}

	public static double toDollar(double won) {
		// TODO Auto-generated method stub
		CurrencyConverter.dollar = won/rate;
		return dollar;
	}

	public static double toKRW(double dollar) {
		// TODO Auto-generated method stub
		CurrencyConverter.won = dollar*rate;
		return won;
	}

}

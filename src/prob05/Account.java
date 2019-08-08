package prob05;

public class Account {
	private static String account;
	private static int balance;
	
	public Account(String string) {
		// TODO Auto-generated constructor stub
		account = string;
		balance = 0;
		System.out.println(account+ "계좌가 개설되었습니다.");
	}

	public String getAccountNo() {
		// TODO Auto-generated method stub
		return account;
	}

	public int getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public void save(int i) {
		// TODO Auto-generated method stub
		balance += i;
		System.out.println(account+ "계좌에" + i+"만원이 입금되었습니다.");
	}

	public void deposit(int i) {
		// TODO Auto-generated method stub
		balance -= i;
		System.out.println(account+ "계좌에" + i+"만원이 출금되었습니다.");
	}

}

package kr.co.itcen.bookmall.vo;

public class OrderBookVo {
	private int no;
	private int no2;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getNo2() {
		return no2;
	}
	public void setNo2(int no2) {
		this.no2 = no2;
	}
	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", no2=" + no2 + "]";
	}
	
}

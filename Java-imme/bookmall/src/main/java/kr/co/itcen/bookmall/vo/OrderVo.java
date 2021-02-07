package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private int no;
	private int price;
	private String order_address;
	private int member_no;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", price=" + price + ", order_address=" + order_address + ", member_no="
				+ member_no + "]";
	}
	
}	

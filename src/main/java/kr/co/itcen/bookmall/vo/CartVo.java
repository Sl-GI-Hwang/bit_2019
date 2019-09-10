package kr.co.itcen.bookmall.vo;

public class CartVo {
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", member_no=" + member_no + ", book_no=" + book_no + ", quantity=" + quantity
				+ "]";
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	private int no;
	private int member_no;
	private int book_no;
	private int quantity;
}

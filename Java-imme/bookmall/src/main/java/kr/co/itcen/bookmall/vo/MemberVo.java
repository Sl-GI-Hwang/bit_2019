package kr.co.itcen.bookmall.vo;

public class MemberVo {
	private int no;
	private String name;
	private String phone;
	private String email;
	private String passwd;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + ", passwd=" + passwd
				+ "]";
	}
	
	
}	

package kr.co.itcen.jblog3.vo;

public class BlogVo {
	private String id;
	private String title;
	private Byte logo;
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", title=" + title + ", logo=" + logo + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Byte getLogo() {
		return logo;
	}
	public void setLogo(Byte logo) {
		this.logo = logo;
	}
}

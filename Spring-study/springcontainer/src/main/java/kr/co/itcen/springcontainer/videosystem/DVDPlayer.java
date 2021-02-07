package kr.co.itcen.springcontainer.videosystem;

public class DVDPlayer {
	private DigitalVideoDisc dvd;

	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	public DigitalVideoDisc getDigitalVideoDisc() {
		return dvd;
	}

	public void setDigitalVideoDisc(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	public void play() {
		dvd.play();
	}
}

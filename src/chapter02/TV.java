package chapter02;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	
	public TV() {
		
	}
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void status() {
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}
	
	public void power(boolean on) {
		power = on;
	}
	public void channel(int channel) {
		if(channel >0 && channel <= 255) {
			this.channel = channel;
		}
	}
	public void channel(boolean up) {
		if(up == true && (channel >0 && channel <= 255))
			channel++;
		else if (up == false && (channel >0 && channel <= 255))
			channel--;
	}
	
	public void volume(int volume) {
		if(volume >= 0 && volume <= 255) {
			this.volume = volume;
		}
	}
	public void volume(boolean up) {
		if(up == true && (volume >= 0 && volume <= 255))
			volume++;
		else if (up == false && (volume >0 && volume <= 255))
			volume--;		
	}
}

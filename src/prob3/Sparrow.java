package prob3;

public class Sparrow extends Bird {
	private String name;

	public String getName() {
		return name;
	}
	
	public String toString() {
		return "참새의 이름은 " + name + " 입니다.";
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void fly() {
		// TODO Auto-generated method stub
		System.out.println("참새("+name+")가 날아다닙니다.");
	}

	@Override
	protected void sing() {
		// TODO Auto-generated method stub
		System.out.println("참새("+name+")가 소리내어 웁니다.");
	}
}

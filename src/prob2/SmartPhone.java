package prob2;

public class SmartPhone extends MusicPhone {
	public void execute(String function) {
		if (function.equals("음악")) {
			playMusic();
			return;
		}
		else if (function.equals("앱")) {
			App();
			return;
		}

		super.execute(function);
	}

	private void App() {
		// TODO Auto-generated method stub
		System.out.println("앱 실행");
	}

	private void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}
	
}

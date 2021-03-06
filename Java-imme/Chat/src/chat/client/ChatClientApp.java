package chat.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

import chat.server.ChatServer;
import chat.server.ChatServerThread;



public class ChatClientApp {
	
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 8000;
	private Map<String,Writer> writers;
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		
		try {
			
			//1. 소캣 만들고
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			//2. iostream 작업
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			PrintWriter pr = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true);
			
			while( true ) {
				
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();

				//3. join 프로토콜 만들기
				String join = "join:"+name;
				pr.println(join);
				String response = br.readLine();
				//대화명 입력받으면 윈도우창 띄움
					
				if ((name.isEmpty() == false ) && ("join:ok".equals(response))) {
					System.out.println("name " + response);		
					break;
				}
				if(name.isEmpty()) {
					System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
				}
				if(!"join:ok".equals(response)) {
					System.out.println("이미 있는 대화명입니다.\n");
				}
			}
			
			//4. join이 성공하면 창 띄우기 
			new ChatWindow(name,socket).show();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				if(scanner != null)scanner.close();
		}

	}

}
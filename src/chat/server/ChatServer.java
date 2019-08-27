package chat.server;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {
	private static final int PORT = 8000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Map <String, Writer> listWriters = new HashMap<String, Writer>();
//		List<Writer> listWriters = new ArrayList<Writer>();

		// 1. 서버 소겟 생성
		try {
			serverSocket = new ServerSocket();
			
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind( new InetSocketAddress( hostAddress, PORT ) );			
			log( "연결 기다림 " + hostAddress + ":" + PORT );

			// 3. 요청 대기 
			while( true ) {
			   Socket socket = serverSocket.accept();
			   new ChatServerThread( socket, listWriters ).start();
//			   new ChatServerThread( socket ).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 

	}
	
	public static void log(String log) {
		System.out.println("[Server#" + Thread.currentThread().getId() + "] " + log);
	}

}

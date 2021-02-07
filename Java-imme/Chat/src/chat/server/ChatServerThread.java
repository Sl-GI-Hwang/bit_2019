package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


public class ChatServerThread extends Thread {
	
	private String nickname;
	private Map<String,Writer> writers;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pr;
	
	public ChatServerThread(Socket socket,Map writers) {
		this.socket = socket;
		this.writers = writers;
	}

	@Override
	public void run() {
		//1. 연결한 소캣의 주소를 가져움
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remotePort = inetRemoteSocketAddress.getPort();
		
		ChatServer.log("connected bt client["+remoteHostAddress + "," + remotePort + "]");
		
		try {
				//2. 스트림 얻기
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				pr = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true);
			
				//3. 요청 처리
				while(true) {
						String request = br.readLine();
						System.out.println("[Server] client Send ["+request+"]");
						if(request == null) {
							ChatServer.log("[Server] Disconnected from Client");
							doQuit(pr);
							break;
						}						
					
						//4. 프로토콜 분석
						String[] tokens = request.split(":");
						
						if("join".equals(tokens[0])) {
							doJoin(tokens[1],pr);
						}else if("message".equals(tokens[0])) {
							if(tokens.length == 1) {
								continue;
							}
														
							String res = request.substring(7);
							doMessage(res);
							
							if("quit".equals(tokens[1])) {
								doQuit(pr);
								break;
							}
						}else {
							ChatServer.log("[Server] Unknown Request :"+tokens[0]);
						}
						
						
					}
			}catch(SocketException e) {
				System.out.println("[Server] Suddenly Closed by Client");
				doQuit(pr);
			}catch(IOException e) {
				System.out.println(e);
			}finally {
				try {
					if(socket != null && !socket.isClosed())
						socket.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
	}

	private void doJoin(String nickname, PrintWriter pr) {
		this.nickname = nickname;
		
		for(String keys:writers.keySet()) {
			if(nickname.equals(keys)) {
				pr.println("no");
				pr.flush();
				return;
			}
		}
		
		String data = nickname + "님이 들어왔습니다.";
		broadcast(data);
		
		addWriter(pr);	
		
		//ack
		pr.println("join:ok");
		pr.flush();
		
	}

	private void doQuit(PrintWriter pr) {	
		synchronized (writers) {
			Iterator<String> iterWrtiers = new HashSet<String>(writers.keySet()).iterator();
			while(iterWrtiers.hasNext()) {
				String key = iterWrtiers.next();
				if(writers.get(key).equals(pr)) {
					writers.remove(key);
				}
			}
		}
		String data = this.nickname + " 님이 퇴장하였습니다.";
		broadcast(data);		
	}

	//메세지 받기
	private void doMessage(String message) {
		String data = this.nickname + ": "+ message;
		broadcast(data);
	}

	private void addWriter(PrintWriter writer) {
		synchronized (writers) {
			writers.put(nickname, writer);
		}
	}
	
	private void broadcast(String data) {
		synchronized (writers) {
			for(Map.Entry<String,Writer> writer : writers.entrySet()){
				 PrintWriter pr = (PrintWriter)writer.getValue();
				 pr.println(data);
				 pr.flush();
			}
		}
	}

	public Map<String, Writer> getWriters() {
		return writers;
	}
	
}

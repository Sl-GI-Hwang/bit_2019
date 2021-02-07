package kr.co.itcen.network.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoServerReceiveThread extends Thread {
	Socket socket;

	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			while(true) {
				byte[] buffer = new byte[256];
				int readByteCount = is.read(buffer);
				if (readByteCount == -1) {
					System.out.println("[TCPServer] closed by client");
					break;
				}
				String data = new String(buffer, 0, readByteCount, "UTF-8");
				os.write(data.getBytes("UTF-8"));
				//			System.out.println("[TCPServer] received:" + data);
			}
		} catch(IOException e) {
			System.out.println(e);
		}
	}
}

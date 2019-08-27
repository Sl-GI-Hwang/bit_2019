package chat.client;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private ChatClientThread thread;
	//private BufferedReader br;

	public ChatWindow(String name,Socket socket) {
		frame = new Frame(name);
		this.socket = socket;
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

		new ChatClientThread(socket).start();
	}
	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					//Enter쳤을 때 전송
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		//thread 생성
	}
	
	private void sendMessage() {
		String message = textField.getText();
		
		System.out.println("[client] 보낸 메세지"+message);
		
		try {
			PrintWriter pr = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),true);
			pr.println("message:"+message);
			if ("quit".equals(message)) {
				System.exit(0);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		//창비우기
		textField.setText("");
		textField.requestFocus();	
		
	}
	
	private void finish() {
		try {
			if(socket!=null && socket.isClosed() == false) {
				socket.close();
				System.exit(0);
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	private class ChatClientThread extends Thread {

		private Socket socket;
		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				BufferedReader br =  new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
				while (true) {

					String newMessage = br.readLine();
					if (newMessage == null) {
						break;
					}
					textArea.append(newMessage);
					textArea.append("\n");
				}
			} catch (IOException e) {
				System.out.println("[Client] Out");
			}
		}
	}
		
	
	
}
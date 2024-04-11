package chat;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.*;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import encryption.Encryption;


public class ChatClient extends JFrame {

	private static final String RSA = "RSA";
	private static final String SERVER_PUBLIC_KEY = "MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgGk9wUQ4G9PChyL5SUkCyuHjTNOglEy5h4KEi0xpgjxi/UbIH27NXLXOr94JP1N5pa1BbaVSxlvpuCDF0jF9jlZw5IbBg1OW2R1zUACK+NrUIAYHWtagG7KB/YcyNXHOZ6Icv2lXXd7MbIao3ShrUVXo3u+5BJFCEibd8a/JD/KpAgMBAAE=";
	private PublicKey serverPublicKey;
	private Key communicationKey;

	private int port = 9898;

	Socket socket = null;
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;

	JTextArea textArea = null;
	JTextField textField = null;

	public ChatClient() {
		super("Chat Client");
		
		createUI();

		try {
			serverPublicKey = Encryption.readPublicKey(SERVER_PUBLIC_KEY);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error getting server public key: " + e.getMessage());
		}
		
	}

	private void createUI() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem connect = new JMenuItem("Connect");
		JMenuItem exit = new JMenuItem("Exit");

		connect.addActionListener(new OpenConnectionListener());
		// exit.addActionListener(e -> System.exit(0));
		exit.addActionListener((e) -> {
			try {
				socket.close();
				textArea.append("Connection closed\n");
			} catch (Exception e1) {
				System.err.println("error");
			}
		});

		fileMenu.add(connect);
		fileMenu.add(exit);
		menuBar.add(fileMenu);

		setJMenuBar(menuBar);

		textArea = new JTextArea(30, 30);
		JScrollPane sp = new JScrollPane(textArea);
		add(sp);
		
		textField = new JTextField(30);
		add(textField, BorderLayout.SOUTH);
		textField.addActionListener(new TextFieldListener());

		setSize(400, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	class OpenConnectionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				socket = new Socket("localhost", port);
				textArea.append("connected\n");
				// Create an input stream to receive data from the server
				fromServer = new DataInputStream(socket.getInputStream());

				// Create an output stream to send data to the server
				toServer = new DataOutputStream(socket.getOutputStream());

				new Thread(new ServerListener()).start();

			} catch (IOException e1) {
				e1.printStackTrace();
				textArea.append("Connection Failure");
			}
		}

	}

	class TextFieldListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Socket socket = null;

			try {
				// Get the text from the text field
				String textInput = textField.getText().trim();
				textArea.append(textInput + '\n');
				textField.setText("");

				// Send the text to the server
				toServer.writeUTF(textInput);
				toServer.flush();
				// socket.close();
			} catch (IOException ex) {
				System.err.println(ex);
			}

		}
	}

	class ServerListener implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					// Get text from the server
					String textReceived = fromServer.readUTF();
					textArea.append(textReceived + "\n");
				}
			} catch (IOException e) {
				System.err.println(e);
			}
		}

	}

	
	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
	}
}

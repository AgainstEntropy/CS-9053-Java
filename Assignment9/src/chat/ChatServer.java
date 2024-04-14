package chat;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;

import encryption.Encryption;

import java.security.*;

public class ChatServer extends JFrame {

	private static final String RSA = "RSA";
	private Key privateKey;

	private JTextArea ta = null;
	private int clientId = 0;
	private ArrayList<DataOutputStream> clients = new ArrayList<>();

	private int port = 9898;

	public ChatServer() {

		super("Chat Server");

		createUI();

		try {
			privateKey = Encryption.readPrivateKey("Assignment9/keypairs/pkcs8_key");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem loading private key: " + e.getMessage());
			System.exit(1);
		}

	}

	private void createUI() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem exit = new JMenuItem("Exit");

		exit.addActionListener(e -> System.exit(0));

		fileMenu.add(exit);
		menuBar.add(fileMenu);

		setJMenuBar(menuBar);

		ta = new JTextArea(30, 30);
		JScrollPane sp = new JScrollPane(ta);
		add(sp);

		setSize(400, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			// Create a server socket
			ta.append("Chat server started at " + new Date() + '\n');

			while (true) {
				// Listen for a new connection request
				Socket socket = serverSocket.accept();

				// Increment clientNo
				clientId++;
				ta.append("Starting thread for client " + clientId +
						" at " + new Date() + '\n');

				InetAddress inetAddress = socket.getInetAddress();
				ta.append("Got connection from client at " + inetAddress.getHostName() + " (" +
						inetAddress.getHostAddress() + ")\n");
				ta.append("Client " + clientId + "'s host name is " +
						inetAddress.getHostName() + '\n');
				ta.append("Client " + clientId + "'s IP Address is " +
						inetAddress.getHostAddress() + '\n');

				// Create and start a new thread for the connection
				new Thread(new ClientHandler(socket, clientId)).start();
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}

	}

	// Define the thread class for handling new connection
	class ClientHandler implements Runnable {
		private Socket socket = null; // A connected socket
		private DataOutputStream toClient = null;
		private DataInputStream fromClient = null;

		private int clientId;
		private Key AESKey = null;

		/** Construct a thread */
		public ClientHandler(Socket socket, int clientId) {
			this.socket = socket;
			this.clientId = clientId;
		}

		private void sendMessage(DataOutputStream client, String message) {
			try {
				client.writeUTF(message);
				client.flush();
			} catch (IOException e) {
				System.err.println("error sending message: " + e.getMessage());
			}
		}

		private String receiveMessage() {
			try {
				return fromClient.readUTF();
			} catch (IOException e) {
				System.err.println("error receiving message: " + e.getMessage());
				return null;
			}
		}

		private byte[] receiveEncryptedSeed() {
			try {
				byte[] encryptedSeed = new byte[128];
				fromClient.read(encryptedSeed);
				return encryptedSeed;
			} catch (IOException e) {
				System.err.println("error receiving encrypted seed: " + e.getMessage());
				return null;
			}
		}

		private boolean receiveHandshake() {
			try {
				// Step 2: Server receives "HELLO" message and sends "CONNECTED" message
				String receivedMessage = receiveMessage();
				if (receivedMessage.equals("HELLO")) {
					sendMessage(toClient, "CONNECTED");
					
					// Step 3: Server receives encrypted seed, decrypts it, and generates AES Key
					byte[] encryptedSeed = receiveEncryptedSeed();
					System.out.println("Received encrypted seed: " + Arrays.toString(encryptedSeed));
					byte[] decryptedSeed = Encryption.pkDecrypt(privateKey, encryptedSeed);
					System.out.println("decrypted seed: " + Arrays.toString(decryptedSeed));
					AESKey = Encryption.generateAESKey(decryptedSeed);
					System.out.println("key (client " + clientId + "): " + AESKey);
				} else {
					System.err.println("Handshake failed");
					return false;
				}
			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
					| IllegalBlockSizeException | BadPaddingException e) {
				e.printStackTrace();
				System.err.println("problem with handshake: " + e.getMessage());
			}
			return true;
		}

		/** Run a thread */
		@Override
		public void run() {
			try {
				// Create data input and output streams
				fromClient = new DataInputStream(
						socket.getInputStream());
				toClient = new DataOutputStream(
						socket.getOutputStream());

				if (receiveHandshake()) {

					clients.add(toClient);
	
					// Continuously serve the client
					while (true) {
						// Receive text from the client
						String text = receiveMessage();
						ta.append("text received from client " + this.clientId + ": " +
								text + '\n');
	
						// Send text back to other clients
						for (DataOutputStream client : clients)
							if (client != toClient) {
								sendMessage(client, this.clientId + ": " + text);
							}
					}
				} else {
					// Close the connection
					socket.close();
				}

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		chatServer.run();
	}

}

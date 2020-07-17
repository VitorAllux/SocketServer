package Cliente;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Client {
	private static Socket socket;

	// connection
	private void connectServer() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 63213);
		System.out.println("Conectado ao Servidor!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		Client client = new Client();
		try {
			client.connectServer();

			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			Scanner scan = new Scanner(System.in);

			while (true) {
				System.out.println("Digite sua mensagem: ");
				String msg = scan.nextLine();
				out.writeObject(msg);
				out.flush();
				try {
					msg = in.readObject().toString();
					System.out.println("Mensagem do servidor: " + msg);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

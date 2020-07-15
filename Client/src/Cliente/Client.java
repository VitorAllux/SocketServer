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
	// frame
	private JFrame frame = new JFrame();
	JTextArea panelChat = new JTextArea();
	JTextField sendTxt = new JTextField();
	JButton brnSair = new JButton("Sair");
	JButton btnEnviar = new JButton("Enviar");
	// communication
	private static Socket socket;

	public Client() {
		initialize();
	}

	private void initialize() {

		// frame

		frame.setTitle("Aircraft Controller!");
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		// jtextpane

		panelChat.setLayout(null);
		JScrollPane scrollBarChat = new JScrollPane(panelChat);
		scrollBarChat.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollBarChat.setBackground(Color.WHITE);
		scrollBarChat.setBounds(10, 10, 365, 400);
		frame.getContentPane().add(scrollBarChat);

		// textfield

		sendTxt.setLayout(null);
		sendTxt.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sendTxt.setBounds(10, 430, 365, 30);
		sendTxt.setHorizontalAlignment(sendTxt.CENTER);
		frame.getContentPane().add(sendTxt);

		// buttons

		btnEnviar.setForeground(Color.BLACK);
		btnEnviar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEnviar.setBackground(Color.ORANGE);
		btnEnviar.setBounds(100, 480, 90, 40);
		frame.getContentPane().add(btnEnviar);

		brnSair.setForeground(Color.BLACK);
		brnSair.setFont(new Font("Arial", Font.PLAIN, 12));
		brnSair.setBackground(Color.ORANGE);
		brnSair.setBounds(200, 480, 90, 40);
		frame.getContentPane().add(brnSair);
	}

	// connection
	private void connectServer() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 55555);
		System.out.println("conectado server");
		panelChat.append("Connectado ao servidor!\n");
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
				System.out.println("digite sua mensagem");
				String msg = scan.nextLine();
				out.writeObject(msg);
				out.flush();
				try {
					msg = in.readObject().toString();
					System.out.println("MSG servidor - " + msg);

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

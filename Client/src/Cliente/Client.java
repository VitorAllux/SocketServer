package Cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	//frame
		private JFrame frame = new JFrame();
		JTextArea panelChat = new JTextArea();
		JTextField sendTxt = new JTextField();
		JButton brnSair = new JButton("Sair");
		JButton btnEnviar = new JButton("Enviar");

		public Client() {
			initialize();
		}

		private void initialize() {

			//frame

			frame.setTitle("Chat Tradutor!");
			frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
			frame.getContentPane().setBackground(Color.WHITE);
			frame.setBounds(100, 100, 400, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setLayout(null);
			frame.setResizable(false);

			//jtextpane

			panelChat.setLayout(null);
			JScrollPane scrollBarChat = new JScrollPane(panelChat);
			scrollBarChat.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			scrollBarChat.setBackground(Color.WHITE);
			scrollBarChat.setBounds(10, 10, 365, 400);
			panelChat.setEditable(false);
			frame.getContentPane().add(scrollBarChat);

			//textfield

			sendTxt.setLayout(null);
			sendTxt.setBorder(new LineBorder(new Color(0,0,0),2));
			sendTxt.setBounds(10, 430, 365, 30);
			sendTxt.setHorizontalAlignment(sendTxt.CENTER);
			frame.getContentPane().add(sendTxt);

			//buttons

			btnEnviar.setForeground(Color.BLACK);
			btnEnviar.setFont(new Font("Arial", Font.PLAIN, 12));
			btnEnviar.setBackground(Color.ORANGE);
			btnEnviar.setBounds(100, 480, 180, 40);
			frame.getContentPane().add(btnEnviar);


		}
	
	private static Socket socket;
	// connection
	private void connectServer() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 63213);
		System.out.println("Conectado ao Servidor!");
		panelChat.setText(panelChat.getText() + " Conectado ao servidor porta 63213! \n\r Chat de tradução iniciado!");
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub;
		Client client = new Client();
		try {
			client.connectServer();
			client.frame.setVisible(true);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			client.panelChat.setText(client.panelChat.getText() + "\n\r Digite sua palavra a ser traduzida: ");

			client.btnEnviar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String msg = client.sendTxt.getText().toString();
					client.panelChat.setText(client.panelChat.getText()  + msg);
					try {
					out.writeObject(msg);
					out.flush();
					msg = in.readObject().toString();
					}
					catch(IOException | ClassNotFoundException io){	
					}
					client.panelChat.setText(client.panelChat.getText() + "\n\r Tradução do servidor: " + msg + "\n\r Digite sua palavra: ");
					System.out.println("Mensagem do servidor: " + msg);
					client.sendTxt.setText(null);
				}
			});
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

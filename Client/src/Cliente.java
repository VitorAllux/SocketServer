import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Cliente {
	//frame
	private JFrame frame = new JFrame();
	JTextArea panelChat = new JTextArea();
	JTextField sendTxt = new JTextField();
	JButton brnSair = new JButton("Sair");
	JButton btnEnviar = new JButton("Enviar");
	
	public Cliente() {
		initialize();
	}
	
	private void initialize() {
		
		//frame

		frame.setTitle("Aircraft Controller!");
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
		btnEnviar.setBounds(100, 480, 90, 40);
		frame.getContentPane().add(btnEnviar);
		

		brnSair.setForeground(Color.BLACK);
		brnSair.setFont(new Font("Arial", Font.PLAIN, 12));
		brnSair.setBackground(Color.ORANGE);
		brnSair.setBounds(200, 480, 90, 40);
		frame.getContentPane().add(brnSair);
	}
	
	//comunication
	private Socket socket;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	private void connectServer() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 55555);
		System.out.println("conectado server");
		panelChat.append("Connectado ao servidor!\n");
	}
	
	private void createStreams() throws IOException {
		output = new ObjectOutputStream(socket.getOutputStream());
		input = new ObjectInputStream(socket.getInputStream());
		System.out.println("streams cridadas");
	
	}
	
	private void closeStreams() throws IOException {
		output.close();
		input.close();
		socket.close();
		panelChat.append("Conex�o com o servidor encerrada!\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Cria o socket
		try {
			Cliente cliente = new Cliente();
			cliente.connectServer();
			cliente.createStreams();
			cliente.frame.setVisible(true);
			
			//fala com o servidor
			output.writeUTF("hello!");
			System.out.println("mensagem enviada Hello!");
			output.flush();
			System.out.println("Mensagem recebida " + input.readUTF());
			output.writeUTF("sair");
			
			cliente.closeStreams();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

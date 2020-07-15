package Controlador;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Controller extends Thread {
	private Socket client;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public Controller(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			out = new ObjectOutputStream(client.getOutputStream());
			in = new ObjectInputStream(client.getInputStream());
			Scanner scan = new Scanner(System.in);
			while (true) {
				String msg = in.readObject().toString();
				System.out.println("Cliente MSG - " + msg);
				System.out.println("digite sua mensagem");
				msg = "padr�o";//scan.nextLine();
				out.writeObject(msg);
				out.flush();
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
}

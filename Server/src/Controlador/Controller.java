package Controlador;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import Tradutor.Dicionario;
import Tradutor.Tradutor;

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
			System.out.println("Conectado com o cliente!");
			Dicionario d = new Dicionario();
			Tradutor t = new Tradutor(d);
			out = new ObjectOutputStream(client.getOutputStream());
			in = new ObjectInputStream(client.getInputStream());
			Scanner scan = new Scanner(System.in);
			while (true) {
				String msgEntrada = in.readObject().toString();
				System.out.println("Mensagem do cliente: " + msgEntrada);
				String msgRetorno = t.traduzir(msgEntrada);// traduz
				if (msgRetorno.equals("Tradução não encontrada!")) {
					System.out.println("Tradução não encontrada para a palavra " + msgEntrada);
					out.writeObject(msgRetorno);
					out.flush();
				} else {
					System.out.println("Tradução encontrada para a palavra " + msgEntrada);
					out.writeObject("Tradução: " + msgRetorno);
					out.flush();
				}
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}

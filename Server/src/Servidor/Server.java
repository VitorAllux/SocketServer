package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Controlador.Controller;

public class Server {
	
	private ServerSocket serverSocket;

	// Criar o server socket
	private void createServerSocket(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("servidor iniciado com sucesso ----> port:" + port);
	}

	// Esperar a conexão com o "cliente", retorna o socket que recebeu a conexão
	private Socket waitConnectionSocket() throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}

	// Fechar Socket
	private void closeSocket(Socket socket) throws IOException {
		socket.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		try {
			server.createServerSocket(63213);
			while(true) {
				Socket client = server.waitConnectionSocket();
				Controller ctr = new Controller(client);
				ctr.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	
	
	//Criar o server socket
	private void createServerSocket(int port) throws IOException {
			serverSocket = new ServerSocket(port);
	}
	
	//Esperar a conexão com o "cliente", retorna o socket que recebeu a conexão
	private Socket waitConnectionSocket() throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}
	
	//Fechar Socket
	private void closeSocket(Socket socket) throws IOException {
		socket.close();
	}
	
	private void processConnection(Socket socket) throws IOException {
		//"cliente" ----> socket <---- "server"
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream()); 
		
			//protocol
			String msg = input.readUTF();
			System.out.println("mensagem recebida " + msg);
			output.writeUTF("Hello World!");
			System.out.println("mensagem envidada " + "Hello World");

			output.flush();
			
			output.close();
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeSocket(socket);
		}


		
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			System.out.println("waiting connection!..");
			server.createServerSocket(55555);
			Socket socket = server.waitConnectionSocket();//protocol
			System.out.println("connected!");
			server.processConnection(socket);//trata conexão
			System.out.println("connection closed!");
		} catch (IOException e) {
			//trata exception
		}


	}
	
	

}

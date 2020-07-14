import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Cria o socket
		try {
			//Conecta servidor
			Socket socket = new Socket("localhost", 55555);
			
			//cria os streams
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			
			//fala com o servidor
			output.writeUTF("hello!");
			System.out.println("mensagem enviada Hello!");
			output.flush();
			System.out.println("Mensagem recebida " + input.readUTF());
			
			//fecha streams
			output.close();
			input.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package pe.com.bcp.jms.colasMQ.config;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EnviaConex {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 5000);
			DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			os.writeBytes("{\"mensaje\": {\"prueba\":\"MensajePrueba 01 \"} }");
			os.flush();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

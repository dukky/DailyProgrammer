package hard15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client class for /r/dailyprogrammer Hard #15
 * 
 * Short description: Write a client/server program using sockets.
 * 
 * @author Andreas Holley
 *
 */
public class Client {
	
	private int port;
	private String address;
	
	public Client(int port, String address) {
		this.port = port;
		this.address = address;
	}
	
	public void run() {
		try {
			Socket s = new Socket(address, port);
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			Scanner in = new Scanner(System.in);
			while(true) {
				String message = in.nextLine();
				pw.println(message);
				pw.flush();
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String address = args[0];
		int port = Integer.parseInt(args[1]);
		Client client = new Client(port, address);
		client.run();
	}
	
}

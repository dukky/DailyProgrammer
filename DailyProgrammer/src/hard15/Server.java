/*******************************************************************************
 * Copyright 2014 Andreas Holley
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package hard15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class for /r/dailyprogrammer Hard #15
 * 
 * Short description: Write a client/server program using sockets.
 * 
 * @author Andreas Holley
 *
 */
public class Server {

	private int port;

	public Server(int port) {
		this.port = port;
	}

	public void run() {
		try {
			ServerSocket socket = new ServerSocket(port);
			Socket remoteSocket = socket.accept();
			System.out.println("Connection from " + remoteSocket.getInetAddress());
			BufferedReader br = new BufferedReader(new InputStreamReader(
					remoteSocket.getInputStream()));
			PrintWriter pw = new PrintWriter(remoteSocket.getOutputStream());
			while (true) {
				String message = br.readLine();
				System.out.println("Message from " + remoteSocket.getInetAddress() + ": " + message);

				if(message.startsWith("rev:")) {
					message = message.substring(4, message.length());
					message = new StringBuilder(message).reverse().toString();
				}
			
				pw.println(message);
				pw.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if (args.length > 0) {
			int port = Integer.parseInt(args[0]);
			Server server = new Server(port);
			server.run();
		} else {
			System.out.println("Please specify port number.");
		}
	}

}

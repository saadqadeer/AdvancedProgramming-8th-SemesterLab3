import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static Socket socket;

	public static void main(String[] args) {
		try {
			int port = 25000;
			ServerSocket serverSocket = new ServerSocket(port);

			System.out
					.println("Server Started and listening to the port 25000");
			
			while (true) {
				// Reading the message from the client
			
				socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				
				String number = br.readLine();
				int choice = Integer.parseInt(number);
				System.out.println("user chosed" + choice);
				search:
				if (choice == 1) {

					String msg = number + "\n";
					bw.write(msg);
					bw.flush();

					String username1 = br.readLine();
					String username2 = br.readLine();

					System.out.println("Message received from client is "
							+ username1);
					System.out.println("Message received from client is "
							+ username2);

					// Multiplying the number by 2 and forming the return
					// message
					String returnMessage;
					Serializer serializer = new Serializer();
					serializer.serializeAddress(username1, username2);
					// Sending the response back to the client.
					returnMessage = username1 + "\n" + username2 + "\n";
					os = socket.getOutputStream();
					osw = new OutputStreamWriter(os);
					bw = new BufferedWriter(osw);
					bw.write(returnMessage);
					System.out.println("Message sent to the client is "
							+ returnMessage);
					bw.flush();
					break search;

				}
				if (choice == 2) {
					String msg = choice + "\n";
					bw.write(msg);
					System.out.println(choice + "\n");
					bw.flush();

					Notes e = null;
					String returnmsg;
					try {
						FileInputStream fileIn = new FileInputStream(
								"F:\\saad.ser");
						ObjectInputStream in = new ObjectInputStream(fileIn);
						e = (Notes) in.readObject();
						in.close();
						fileIn.close();
					} catch (IOException i) {
						i.printStackTrace();
						return;
					}
					returnmsg = e.getStreet() + "\n" + e.getCountry() + "\n";

					bw.write(returnmsg);
					System.out.println("Message sent to the client is "
							+ returnmsg);
					bw.flush();

				}
				if (choice == 3) {
					System.out.println("Exiting The System!");
					System.exit(0);
				}

			}// while ends
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
			}
		}
	}
}
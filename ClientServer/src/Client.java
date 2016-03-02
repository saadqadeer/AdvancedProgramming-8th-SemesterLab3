import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private static Socket socket;

	public static void main(String args[]) {
		try {
			String host = "localhost";
			int port = 25000;
			InetAddress address = InetAddress.getByName(host);
			socket = new Socket(address, port);

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String username = null;
			String description = null;
			int choice = 0;
			String k=null;
			String snd=null;
			Scanner i = new Scanner(System.in);
			while (true) {
				bw.flush();
				System.out.println("Press 1 for recording\nPress 2 for retreieving\nPress 3 for exit");
				
				k = i.nextLine();
				snd = k + "\n";
				System.out.println("alskfjd");
				// System.out.println(snd);

				bw.write(snd);
				bw.flush();

				String message1 = br.readLine();
				choice = Integer.parseInt(message1);
				System.out.println(choice);
				
				if (choice == 1) {
					System.out.println("Enter UserName!");
					username = i.nextLine();
					System.out.println("Enter Notes Description");
					description = i.nextLine();
					String sendMessage = username + "\n" + description + "\n";
					bw.write(sendMessage);
					bw.flush();
					System.out.println("Message sent to the server : "
							+ sendMessage);

					String message = br.readLine();
					String mesage2 = br.readLine();
					System.out.println("Note Saved Successfully");
					System.out.println("Notes UserName:" + message
							+ "\nNotes Description:" + mesage2);

				
					

				} else if (choice == 2) {
					System.out.println("Retrieving Notes From The Server");

					String message = br.readLine();
					String mesage2 = br.readLine();
					System.out.println("Note Retreived Successfully");
					System.out.println("Notes UserName:" + message
							+ "\nNotes Description:" + mesage2);
					

				} else {
					System.out.println("Program Exited Successfully!");
					System.exit(0);
				}
			}

		}

		catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			// Closing the socket
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
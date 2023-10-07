package MyFirstSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for clients...");
            // Create Server Socket object with port number = 6618
            // Port number is to identify your application on the network
            // We use try catch to handle IO exceptions
            ServerSocket serverSocket = new ServerSocket(6618);
            while (true) {
                // As soon as it gets connection it will return a socket object
                Socket socket = serverSocket.accept();
                System.out.println("Connection Established!");

                // Read data from socket input stream
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String string = socketInput.readLine();

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("Server says: " + string);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
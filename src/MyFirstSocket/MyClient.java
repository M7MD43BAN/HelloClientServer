package MyFirstSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client Started.");
            //Create socket object with IP address or localhost and port number of server socket
            Socket socket = new Socket("localhost", 6618);

            //Create object to read input from user using keyboard
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a string...");
            String string = userInput.readLine();

            /*
            ******* Send output to socket server *******
            When you write data to a stream, it is not written immediately, and it is buffered.
            So use flush() when you need to be sure that all your data from buffer is written.
            PrintWriter has auto flush by set true to second parameter.
            */
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(string);

            // Read string from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}

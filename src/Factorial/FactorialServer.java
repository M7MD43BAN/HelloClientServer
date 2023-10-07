package Factorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FactorialServer {
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for clients...");
            ServerSocket serverSocket = new ServerSocket(6618);

            while (true) {
                // As soon as it gets connection it will return a socket object
                Socket socket = serverSocket.accept();
                System.out.println("Connection Established!");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                int number = Integer.parseInt(in.readLine());

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Factorial of " + number + " is: " + factorial(number));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    static int factorial(int number) {
        if (number >= 1)
            return number * factorial(number - 1);
        else
            return 1;
    }
}

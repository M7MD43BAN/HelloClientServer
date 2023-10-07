package Factorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FactorialClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client Started.");
            Socket socket = new Socket("localhost", 6618);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number: ");
            int number = Integer.parseInt(userInput.readLine());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(number);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}

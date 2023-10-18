package MatrixMultiplication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class FirstClient {
    public static void main(String[] args) {
        Socket socket;
        Scanner scanner;
        ObjectOutputStream objectOutputStream;
        int rows, columns;
        MatrixModel firstMatrix;

        try {
            System.out.println("First Client Started.");
            socket = new Socket(NetworkConstants.SERVER_IP, NetworkConstants.SERVER_PORT);

            scanner = new Scanner(System.in);

            System.out.println("Enter size of the First Matrix...");
            System.out.print("rows = ");
            rows = scanner.nextInt();
            System.out.print("columns = ");
            columns = scanner.nextInt();

            firstMatrix = new MatrixModel(rows, columns);

            System.out.println("Enter Elements of First Matrix");
            firstMatrix.setMatrixFromUserInput(scanner);

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(firstMatrix);

            objectOutputStream.flush();
            objectOutputStream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
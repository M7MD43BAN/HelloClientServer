package MatrixMultiplication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        ObjectInputStream objectInputStream;
        MatrixModel firstMatrix = null, secondMatrix, resultMatrix;

        boolean firstClientConnected = false;

        try {
            System.out.println("Waiting for clients...");
            serverSocket = new ServerSocket(NetworkConstants.SERVER_PORT);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connection Established!");

                objectInputStream = new ObjectInputStream(socket.getInputStream());

                if (!firstClientConnected) {
                    firstMatrix = (MatrixModel) objectInputStream.readObject();
                    firstClientConnected = true;
                } else {
                    secondMatrix = (MatrixModel) objectInputStream.readObject();
                    resultMatrix = firstMatrix.multiply(secondMatrix);

                    resultMatrix.printMatrix();

                    socket.close();
                    firstClientConnected = false;
                }

                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
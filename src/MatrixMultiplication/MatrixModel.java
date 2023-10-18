package MatrixMultiplication;

import java.io.Serializable;
import java.util.Scanner;

public class MatrixModel implements Serializable {
    private final int[][] data;
    private final int rows;
    private final int columns;

    public MatrixModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public void setElement(int row, int col, int value) {
        data[row][col] = value;
    }

    public int getElement(int row, int col) {
        return data[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setMatrixFromUserInput(Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int element = scanner.nextInt();
                this.setElement(i, j, element);
            }
        }
    }

    public MatrixModel multiply(MatrixModel other) {
        if (this.getColumns() != other.getRows()) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication.");
        }

        MatrixModel result = new MatrixModel(this.getRows(), other.getColumns());

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                int sum = 0;
                for (int k = 0; k < this.getColumns(); k++) {
                    sum += this.getElement(i, k) * other.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public void printMatrix() {
        System.out.println("Result Matrix:");
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                System.out.printf("%5d ", getElement(i, j));
            }
            System.out.println();
        }
    }
}

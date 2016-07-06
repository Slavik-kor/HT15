package by.trepam.karotki.ht15.main;

import by.trepam.karotki.ht15.exception.MatrixException;
import by.trepam.karotki.ht15.multiplication.FixedThreadMatrixMultiplication;

public class FixedThreadsDemo {

	public static void main(String[] args) throws InterruptedException, MatrixException {
		int[][] matrix1 = { { 1, 2, 3 }, { 1, 3, 2 }, { 3, 2, 6 } };
		int[][] matrix2 = { { 1, 2, 3 }, { 1, 3, 2 }, { 3, 2, 6 } };
		int[][] matrix = new int[3][3];

		FixedThreadMatrixMultiplication m = new FixedThreadMatrixMultiplication(matrix1, matrix2, 5);
		matrix = m.calculate();
		for (int[] i : matrix) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}

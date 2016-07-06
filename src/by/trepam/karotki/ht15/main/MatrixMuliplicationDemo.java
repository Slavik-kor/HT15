package by.trepam.karotki.ht15.main;

import by.trepam.karotki.ht15.exception.MatrixException;
import by.trepam.karotki.ht15.part_1.MatrixMultiplication;

public class MatrixMuliplicationDemo {
	public final static int[][] FIRST_MATRIX = { { 1, 2, 3 }, { 1, 3, 2 }, { 3, 2, 6 } };
	public final static int[][] SECOND_MATRIX = { { 1, 2, 3 }, { 1, 3, 2 }, { 3, 2, 6 } };

	public static void main(String[] args) throws InterruptedException, MatrixException {
		
		int[][] matrix = new int[FIRST_MATRIX.length][SECOND_MATRIX[0].length];
		
		MatrixMultiplication multiplication = new MatrixMultiplication(FIRST_MATRIX, SECOND_MATRIX);
		matrix = multiplication.calculate();
		for (int[] i : matrix) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}

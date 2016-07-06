package by.trepam.karotki.ht15.main;

import by.trepam.karotki.ht15.exception.MatrixException;
import by.trepam.karotki.ht15.part_2.LimitedThreadsMatrixMult;

public class LimitedThreadsDemo {
	public final static int[][] FIRST_MATRIX = { { 1, 2, 3 }, { 1, 3, 2 }, { 3, 2, 6 } };
	public final static int[][] SECOND_MATRIX = { { 1, 2, 3 }, { 1, 3, 2 }, { 3, 2, 6 } };
	public final static int AMOUNT_THREADS = 2;
	
	public static void main(String[] args) throws InterruptedException, MatrixException {
		
		int[][] matrix = new int[3][3];

		LimitedThreadsMatrixMult m = new LimitedThreadsMatrixMult(FIRST_MATRIX, SECOND_MATRIX, AMOUNT_THREADS);
		matrix = m.calculate();
		for (int[] i : matrix) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}

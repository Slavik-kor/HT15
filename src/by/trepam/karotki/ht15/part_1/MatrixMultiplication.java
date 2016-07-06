package by.trepam.karotki.ht15.part_1;

import by.trepam.karotki.ht15.exception.MatrixException;

public class MatrixMultiplication {
	private int[][] matrix1;
	private int[][] matrix2;
	private int[][] resultMatrix;
	private int resultMatrixRows;
	private int resultMatrixCols;

	public MatrixMultiplication(int[][] matrix1, int[][] matrix2) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
	}

	public int[][] calculate() throws InterruptedException, MatrixException {
		if (!validate()) {
			throw new MatrixException("Matrix isn't valid");
		}
		resultMatrixRows = matrix1.length;
		resultMatrixCols = matrix2[0].length;

		resultMatrix = new int[resultMatrixRows][resultMatrixCols];
		Thread[] thread = new Thread[resultMatrixRows];
		for (int i = 0; i < resultMatrixRows; i++) {
			for (int j = 0; j < resultMatrix[i].length; j++) {
				thread[i] = new Thread(new SingleValueThread(matrix1, matrix2, resultMatrix, i, j));
				thread[i].start();
			}
		}
		try {
			for (int i = 0; i < resultMatrixRows; i++) {
				thread[i].join();
			}
		} catch (InterruptedException e) {
			throw new InterruptedException("Thread was interrupted");
		}
		return resultMatrix;
	}

	private boolean validate() {
		int a = matrix1[0].length;
		for (int[] i : matrix1) {
			if (i.length != a) {
				return false;
			}
		}
		int b = matrix2[0].length;
		for (int[] i : matrix2) {
			if (i.length != b) {
				return false;
			}
		}
		if (matrix1.length == matrix2[0].length) {
			return true;
		}
		return false;
	}

}

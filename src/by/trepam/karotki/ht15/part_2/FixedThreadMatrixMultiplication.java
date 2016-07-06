package by.trepam.karotki.ht15.part_2;

import by.trepam.karotki.ht15.exception.MatrixException;

public class FixedThreadMatrixMultiplication {
	private int[][] matrix1;
	private int[][] matrix2;
	private int amountThreads;
	private int[][] resultMatrix;
	private int resultMatrixRows;
	private int resultMatrixCols;

	public FixedThreadMatrixMultiplication(int[][] matrix1, int[][] matrix2, int amountThreads) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.amountThreads = amountThreads;
	}

	public int[][] calculate() throws InterruptedException, MatrixException {
		if (!validate()) {
			throw new MatrixException("Matrix isn't valid");
		}
		resultMatrixRows = matrix1.length;
		resultMatrixCols = matrix2[0].length;

		resultMatrix = new int[resultMatrixRows][resultMatrixCols];
		if (resultMatrixRows < amountThreads) {
			amountThreads = resultMatrixRows;
		}

		Thread[] thread = new Thread[amountThreads];
		int amountRows = resultMatrixRows / amountThreads;
		int reminder = resultMatrixRows % amountThreads;
		int begin = 0;
		for (int i = 0; i < thread.length; i++) {
			if (i == thread.length - 1) {
				amountRows += reminder;
			}
			thread[i] = new Thread(
					new RangeValuesThread(matrix1, matrix2, resultMatrix, begin, begin + amountRows - 1));
			thread[i].start();
			begin += amountRows;
		}

		try {
			for (int i = 0; i < thread.length; i++) {
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

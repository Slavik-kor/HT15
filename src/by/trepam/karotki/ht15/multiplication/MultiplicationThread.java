package by.trepam.karotki.ht15.multiplication;

public class MultiplicationThread implements Runnable {
	private int[][] matrix1;
	private int[][] matrix2;
	private int[][] resultMatrix;
	private int beginRow;
	private int endRow;

	public MultiplicationThread(int[][] matrix1, int[][] matrix2, int[][] resultMatrix, int beginRow, int endRow) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.resultMatrix = resultMatrix;
		this.beginRow = beginRow;
		this.endRow = endRow;
	}

	@Override
	public void run() {

		for (int i = beginRow; i <= endRow; i++) {
			for (int k = 0; k < matrix1.length; k++) {
				resultMatrix[i][k] = calculateSingle(i, k);
			}

		}

	}

	private int calculateSingle(int i, int k) {
		int mValue = 0;
		for (int j = 0; j < matrix2.length; j++) {
			mValue += matrix1[i][j] * matrix2[j][k];
		}
		return mValue;
	}

}

package by.trepam.karotki.ht15.part_1;

public class SingleValueThread implements Runnable {
	private int[][] matrix1;
	private int[][] matrix2;
	private int[][] resultMatrix;
	private int row;
	private int col;

	public SingleValueThread(int[][] matrix1, int[][] matrix2, int[][] resultMatrix, int row, int col) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.resultMatrix = resultMatrix;
		this.row = row;
		this.col = col;
	}

	public void run() {
		int mValue = 0;
		for (int i = 0; i < matrix2.length; i++) {
			mValue += matrix1[row][i] * matrix2[i][col];
		}
		resultMatrix[row][col] = mValue;
	}

}

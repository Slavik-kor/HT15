package by.trepam.karotki.ht15.main;

import by.trepam.karotki.ht15.multiplication.MatrixMultiplication;

public class MatrixMuliplicationDemo {

	public static void main(String[] args) throws InterruptedException{
		int[][] matrix1 = { { 1, 2, 3 }, { 1, 3, 2 }, { 3, 2, 6 } };
		int[][] matrix2 = { { 1, 2, 3 }, { 1, 3, 2 }, { 3, 2, 6 } };
		int[][] matrix = new int[3][3];
		MatrixMultiplication multiplication = new MatrixMultiplication(matrix1,matrix2);
		matrix = multiplication.calculate();
		for (int[] i : matrix){
			for (int j : i){
				System.out.print(j+" ");
			}
			System.out.println();
		}

		
	}

}

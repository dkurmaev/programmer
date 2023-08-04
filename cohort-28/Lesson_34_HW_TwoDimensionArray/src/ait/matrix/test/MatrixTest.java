package ait.matrix.test;

import ait.matrix.utils.Matrix;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixTest {
	int[][] matrix1 = {{1, 2, 3}};
	int[][] matrix2 = {{1}, {2}, {3}};

	@Test
	void testSum() {
		int result = Matrix.sum(matrix1);
		System.out.println("Sum: " + result);
		assertEquals(6, result);
		result = Matrix.sum(matrix2);
		System.out.println("Sum: " + result);
		assertEquals(6, result);
	}

	@Test
	void testTransp() {
		int[][] expected = {{1}, {2}, {3}};
		int[][] result = Matrix.transp(matrix1);
		System.out.print("Transposed Matrix: ");
		System.out.println(Arrays.deepToString(result)); // Выводит: Transposed Matrix: [1, 2, 3]
		assertArrayEquals(expected, result);
	}


	@Test
	void testMultiply() {
		int[][] expected1 = {{14}};
		int[][] result1 = Matrix.multiply(matrix1, matrix2);
		printMatrix(result1);
		assertArrayEquals(expected1, result1);
		int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] arr2 = {{1, 2}, {3, 4}, {5, 6}};
		int[][] expected2 = {{22, 28}, {49, 64}};
		int[][] result2 = Matrix.multiply(arr1, arr2);
		printMatrix(result2);
		assertArrayEquals(expected2, result2);
	}

	private void printMatrix(int[][] matrix) {
		System.out.println("Matrix:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}


}




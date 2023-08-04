package ait.matrix.utils;

public class Matrix {

	public static int sum(int[][] matrix) {
		int sum = 0; // Переменная для хранения суммы элементов
		for (int i = 0; i < matrix.length; i++) { // Цикл по строкам матрицы
			for (int j = 0; j < matrix[i].length; j++) { // Цикл по столбцам матрицы
				sum += matrix[i][j]; // Добавление элемента к сумме
			}
		}
		return sum; // Возврат суммы
	}


	public static int[][] transp(int[][] matrix) {
		int rows = matrix.length; // Количество строк в исходной матрице
		int cols = matrix[0].length; // Количество столбцов в исходной матрице
		int[][] transposed = new int[cols][rows]; // Создание новой матрицы для транспонированной матрицы
		for (int i = 0; i < rows; i++) { // Цикл по строкам исходной матрицы
			for (int j = 0; j < cols; j++) { // Цикл по столбцам исходной матрицы
				transposed[j][i] = matrix[i][j]; // Заполнение элементов транспонированной матрицы
			}
		}
		return transposed; // Возврат транспонированной матрицы
	}


	public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
		int rows1 = matrix1.length; // Количество строк в первой матрице
		int cols1 = matrix1[0].length; // Количество столбцов в первой матрице
		int cols2 = matrix2[0].length; // Количество столбцов во второй матрице
		int[][] res = new int[rows1][cols2]; // Создание новой матрицы для результата умножения
		for (int i = 0; i < rows1; i++) { // Цикл по строкам первой матрицы
			for (int j = 0; j < cols2; j++) { // Цикл по столбцам второй матрицы
				for (int k = 0; k < cols1; k++) { // Цикл по столбцам первой матрицы (и строкам второй матрицы)
					res[i][j] += matrix1[i][k] * matrix2[k][j]; // Умножение и суммирование элементов
				}
			}
		}
		return res; // Возврат результата умножения
	}
}

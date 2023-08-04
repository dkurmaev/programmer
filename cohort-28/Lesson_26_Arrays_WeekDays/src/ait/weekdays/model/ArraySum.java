package ait.weekdays.model;

/*
Задайте массив на 10 элементов и заполните его случайными числами в интервале от -10 до 10.
Распечатайте полученный массив. Найдите сумму элементов массива c нечетными индексами.
Разработайте соответсвующий тест (набор тестов).
 */

public class ArraySum {
	public void main(String[] args) {
		int[] array = new int[10];
		int a = -10;
		int b = 10;

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (b - a + 1) + a);

		}
		printArray(array);
		int sum = sumElOddInd(array);
		System.out.println("Sum of Elements with odd indexses = " + sum);

	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]  + "\t"  + "|");
			//System.out.println(Arrays.toString(arr) + "\t");
		}
		System.out.println();
	}

	public  int sumElOddInd(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				sum += arr[i];


			}
		}

		return sum;
	}
}


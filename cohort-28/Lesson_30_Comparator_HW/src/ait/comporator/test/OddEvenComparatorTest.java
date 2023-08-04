package ait.comporator.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class OddEvenComparatorTest {

	Integer[] arrOrigin; //Объявление переменной arrOrigin, которая будет хранить исходный массив.


	@BeforeEach
	void setUp() { //Метод, выполняющий настройку перед каждым тестом.
		arrOrigin = new Integer[]{1, 4, 3, 2, 5, 6, 9, 8, 7, 3};//Инициализация переменной arrOrigin с исходными данными.

	}

	@Test
	void testOddEvenComparator() {//Тестовый метод для проверки сортировки с помощью компаратора OddEvenComparator.
		System.out.println("============= testOddEvenComparator ===============");
		Comparator<Integer> comparator = (num1, num2) -> {//Компаратор сравнивает числа по остатку от деления на 2 и затем использует стандартное сравнение для сортировки чисел.
			int res = Integer.compare(num1 % 2, num2 % 2);
			return res != 0 ? res : (num1.compareTo(num2));
		};
		System.out.println("Before sorting: " + Arrays.toString(arrOrigin));//Вывод исходного массива перед сортировкой.
		Arrays.sort(arrOrigin, comparator);//Сортировка массива arrOrigin с использованием компаратора comparator.
		System.out.println("After sorting: " + Arrays.toString(arrOrigin));//Вывод исходного массива после сортировки.
		System.out.println();
	}

	@Test
	void testOddEvenComparator2() {
		System.out.println("============= testOddEvenComparator2 ===============");
		Comparator<Integer> comparator = (num1, num2) -> {
			int res = Integer.compare(num1 % 2, num2 % 2);
			return res != 0 ? res : (num1 % 2 == 0 ? num1.compareTo(num2) : num2.compareTo(num1));
		};
		System.out.println("Before sorting: " + Arrays.toString(arrOrigin));
		Arrays.sort(arrOrigin, comparator);
		System.out.println("After sorting: " + Arrays.toString(arrOrigin));
	}
}


package ait.arrays.test;

import ait.arrays.utils.ArrayTools;
import ait.soldier.model.Soldier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayToolsTest {
	Integer[] arrNum;
	String[] arrStr;

	Soldier[] soldiers;

	@BeforeEach
	void setUp() {
		// Инициализация массивов и объектов перед каждым тестом
		arrNum = new Integer[]{9, 7, 4, 7, 2, 5, 9, 1, 0};
		arrStr = new String[]{"one ", "two ", "three", "four", "five"};
		soldiers = new Soldier[]{
				new Soldier("John", 182, 82.3, 91),
				new Soldier("Peter", 175, 77.1, 75),
				new Soldier("Rebindranat", 162, 69.3, 82),
				new Soldier("Mary", 159, 55.1, 91),
				new Soldier("Ann", 162, 55, 88)
		};
	}

	@Test
	void testPrintArray() {
		// Тест метода printArray()
		System.out.println("================ testPrintArray ================");
		ArrayTools.printArray(arrNum); // Вывод массива arrNum
		ArrayTools.printArray(arrStr); // Вывод массива arrStr
	}

	@Test
	void testSearch() {
		// Тест метода searchIndex()
		System.out.println("================== testSearch ==================");
		int index = ArrayTools.searchIndex(arrStr, "four"); // Поиск индекса элемента "four" в массиве arrStr
		System.out.println("Index of four is = " + index);
		index = ArrayTools.searchIndex(arrStr, "six"); // Поиск индекса элемента "six" в массиве arrStr (элемент отсутствует)
		System.out.println(("Index of six is = " + index));
	}

	@Test
	void testFindByPredicate() {
		// Тест метода findByPredicate()
		System.out.println("============= testFindByPredicate ==============");
		Integer res = ArrayTools.findByPredicate(arrNum, n -> n % 5 == 0); // Поиск элемента, удовлетворяющего предикату (число, которое делится на 5)
		System.out.println(res);
		res = ArrayTools.findByPredicate(arrNum, n -> n < 5); // Поиск элемента, удовлетворяющего предикату (число меньше 5)
		System.out.println(res);
		String str = ArrayTools.findByPredicate(arrStr, s -> s.length() == 4); // Поиск элемента, удовлетворяющего предикату (строка длиной 4 символа)
		System.out.println(str);
	}

	@Test
	void testBubbleSort() {
		// Тест метода bubbleSort()
		System.out.println("=============== testBubbleSort =================");
		ArrayTools.bubbleSort(arrNum); // Сортировка массива arrNum методом bubbleSort()
		ArrayTools.printArray(arrNum); // Вывод отсортированного массива arrNum
		ArrayTools.bubbleSort(arrStr); // Сортировка массива arrStr методом bubbleSort()
		ArrayTools.printArray(arrStr); // Вывод отсортированного массива arrStr
		ArrayTools.printArray(soldiers); // Вывод массива soldiers
		ArrayTools.bubbleSort(soldiers); // Сортировка массива soldiers методом bubbleSort()
		ArrayTools.printArray(soldiers); // Вывод отсортированного массива soldiers
	}

	@Test
	void testSortSoldiersByName() {
		// Тест сортировки солдат по имени

		ArrayTools.bubbleSort(soldiers, (s1, s2) -> s1.getName().compareTo(s2.getName())); // Сортировка массива soldiers по имени с использованием компаратора
		ArrayTools.printArray(soldiers); // Вывод отсортированного массива soldiers
	}

	@Test
	void testSortString() {
		// Тест сортировки строк
		System.out.println("=============== testSortString =================");
		Arrays.sort(arrStr); // Сортировка массива arrStr методом sort() из класса Arrays
		ArrayTools.printArray(soldiers); // Вывод отсортированного массива arrStr
	}

	@Test
	void testSortStringByLength() {
		// Тест сортировки строк по длине
		System.out.println("=============== testSortStringByLength =================");
		Arrays.sort(arrStr, (s1, s2) -> s2.length() - s1.length()); // Сортировка массива arrStr по длине строк с использованием компаратора
		ArrayTools.printArray(soldiers); // Вывод отсортированного массива arrStr
	}
}

package ait.arrays.utils;

import java.util.Comparator;
import java.util.function.Predicate;

public class ArrayTools {
	// Метод для печати массива на консоль
	public static void printArray(Object[] arr) { //принимает массив arr типа Object[] и выводит его элементы на консоль.
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "\t");
		}
		System.out.println("\n================================================");
	}

	/*
	Метод для поиска индекса элемента value в массиве arr. Он проходит по массиву arr и
	сравнивает каждый элемент с value. Если элемент равен value, то возвращает его индекс.
	Если такого элемента не найдено, возвращает -1.
	 */
	public static int searchIndex(Object[] arr, Object value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	/*
	 Метод для поиска элемента в массиве arr по заданному предикату predicate. Он проходит по массиву arr
	  и проверяет каждый элемент на соответствие предикату predicate. Если найден элемент,
	  для которого предикат выполняется, возвращает этот элемент. Если такой элемент не найден, возвращает null.
	 */
	public static <T> T findByPredicate(T[] arr, Predicate<T> predicate) {
		for (int i = 0; i < arr.length; i++) {
			if (predicate.test(arr[i])) {
				return arr[i];
			}
		}
		return null;
	}

	/*
	Метод сортировки пузырьком для массива элементов, реализующих интерфейс Comparable. Он принимает массив arr
	типа T[], где T - тип элементов массива, реализующих интерфейс Comparable. Метод сортирует элементы
	массива в порядке возрастания, используя метод compareTo() интерфейса Comparable.
	Для сортировки используется алгоритм сортировки пузырьком.
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					// Обмен элементов
					T t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
	}

	/*
	Метод сортировки пузырьком для массива элементов с использованием внешнего компаратора comparator.
	Он принимает массив arr типа T[] и внешний компаратор comparator типа Comparator<T>,
	где T - тип элементов массива. Метод сортирует элементы массива в порядке, определенном компаратором comparator.
	Для сравнения элементов используется метод compare() интерфейса Comparator.
	Для сортировки используется алгоритм сортировки пузырьком.
	 */
	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (comparator.compare(arr[j], arr[j + 1]) > 0) {
					// Обмен элементов
					T t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
	}

}

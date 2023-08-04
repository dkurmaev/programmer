package ait.duplicate.model;

import java.util.*;

/*
Задача о поиске дубликата. Заполните массив последовательными натуральными числами от 1 до 100.
Задумайте случайное натуральное число в интервале от 1 до 100 и вставьте его в массив на случайное место.
Теперь в массиве есть пара дубликатов. Найдите дубликат наименее затратным по вычислениям способом.
 */

public class FindDuplicate {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			list.add(i);
		}
		list.add(21,5);
		System.out.println("Original list: " + list);
		System.out.println("Duplicate: " + findDuplicate(list));
	}
	public static int findDuplicate(List<Integer> list) {
		int duplicate = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.indexOf(list.get(i)) != list.lastIndexOf(list.get(i))) {
				duplicate = list.get(i);
				break;
			}
		}
		return duplicate;
	}
}
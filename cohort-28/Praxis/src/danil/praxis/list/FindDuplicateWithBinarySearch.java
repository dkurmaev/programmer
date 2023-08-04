package danil.praxis.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindDuplicateWithBinarySearch {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		List<Integer> listWithDuplicate = generateAndInsertDuplicate(list, sortedList);
		System.out.println("Первоначальный список: ");
		for (Integer integer : list) {
			System.out.print(integer + "\t");
		}
		System.out.println();
		System.out.println("Отсортированный список: ");
		for (Integer integer : sortedList) {
			System.out.print(integer + "\t");
		}
		System.out.println();

		System.out.println("Список с дубликатом: ");
		for (Integer integer : listWithDuplicate) {
			System.out.print(integer + "\t");
		}
		System.out.println();

		int duplicate = findDuplicate(sortedList);
		System.out.println("Дубликат вставленное число: " + duplicate);
	}

	public static List<Integer> generateAndInsertDuplicate(List<Integer> list, List<Integer> sortedList) {
		for (int i = 1; i <= 100; i++) {
			list.add(i);
		}
		int duplicate = (int) (Math.random() * 100) + 1;
		int indexToInsert = (int) (Math.random() * 100);
		list.add(indexToInsert, duplicate);
		sortedList.addAll(list);
		Collections.sort(sortedList);

		return list;
	}

	public static int findDuplicate(List<Integer> sortedList) {
		int left = 0;
		int right = sortedList.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (sortedList.get(mid).equals(sortedList.get(mid + 1))) {
				return sortedList.get(mid);
			} else if (sortedList.get(mid) > mid + 1) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}

package ait.myarray.model;

import ait.myarray.model.MyArrayList;

public class MyArrayListAppl {
	public static void main(String[] args) {
		MyArrayList<String> myList = new MyArrayList<>();
		myList.add("Danil");
		myList.add("Nikita");
		myList.add("Denis");
		System.out.print("============= Elements =============\n");
		for (int i = 0; i < myList.size(); i++) {
			System.out.print(myList.get(i) + " ");
		}
		System.out.println("\n========== Размер списка ==========");
		int size = myList.size();
		System.out.println(size);
		System.out.println("========== Индекс элемента Nikita ==========");
		int index = myList.indexOf("Nikita");
		System.out.println("Индекс элемента 'Nikita': " + index);
		myList.add("Danil");
		System.out.println("Список после добавления дубликата 'Danil': " + myList.size());
		myList.remove("Denis");
		System.out.println("===========Список после удаления 'Denis'==========");
		for (int i = 0; i < myList.size(); i++) {
			System.out.print(myList.get(i) + " ");
		}
		System.out.println();

		boolean contains = myList.contains("Denis");
		System.out.println("Наличие элемента 'Denis': " + contains);

		System.out.println("============ Список с индексами: =============");
		for (int i = 0; i < myList.size(); i++) {
			System.out.println("Индекс " + i + ": " + myList.get(i));
		}
		System.out.println("============= Сортировка списка ============");
		myList.sort();
		for (int i = 0; i < myList.size(); i++) {
			System.out.println("Индекс " + i + ": " + myList.get(i));
		}
		myList.set(1, "Katie");
		System.out.println("=========== Список после обновления элемента на позиции 1 ==========");
		for (int i = 0; i < myList.size(); i++) {
			System.out.print(myList.get(i) + " ");
		}
		System.out.println();

	}
}

package ait.list;

import ait.list.interfaces.IList;
import ait.list.model.MyArrayList;

public class ListAppl {
	public static void main(String[] args) {
		IList<Integer> list = new MyArrayList<>();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.add(2);
		list.add(7);
		list.add(3);
		list.add(5);
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.add(null);
		list.add(7);
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(4));
		System.out.println(list.indexOf(3));
		System.out.println(list.indexOf(7));
		System.out.println(list.contains(5));
		System.out.println(list.contains(-5));
		System.out.println(list.indexOf(5));
		System.out.println(list.indexOf(null));
		System.out.println("===== Test Homework =====");
		//TODO
		System.out.println("Size before remove: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		System.out.println();
		System.out.println("====== Elements before remove =====");
		System.out.print("Elements: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		System.out.println("\n============= Remove ==============");
		list.remove(2);
		System.out.println("Size after remove: " + list.size());
		System.out.println();
		System.out.println("======Elements after remove======");
		System.out.print("Elements: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		System.out.println("\n=================================");
		System.out.println("Contains 3: " + list.contains(3));
		System.out.println("Contains 5: " + list.contains(5));
		System.out.println("Index of 2: " + list.indexOf(2));
		System.out.println("Last index of 1: " + list.lastIndexOf(7));
		System.out.println("Current size: " + list.size());
		System.out.println();
		System.out.println("============= Set elements =============");
		System.out.println("Set for index 0, 1: " + list.set(3, 3));
		System.out.println("============= Elements after set =============");
		System.out.print("Elements: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		list.clear();
		System.out.println("=============Clear=============");
		System.out.println("Size after clearing: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		System.out.println("============= TryCatch =============");
		try {
			System.out.println("Set for index 0, 1: " + list.set(1, 7));
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Index out of bound");
		}

	}
}
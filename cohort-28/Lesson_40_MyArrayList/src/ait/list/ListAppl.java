package ait.list;

import ait.list.interfaces.IList;
import ait.list.model.MyArrayList;

public class ListAppl {

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("Size before remove: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		list.remove(2);
		System.out.println("Size after remove: " + list.size());
		System.out.println("Contains 3: " + list.contains(3));
		System.out.println("Index of 2: " + list.indexOf(2));
		System.out.println("Last index of 1: " + list.lastIndexOf(1));
		System.out.print("Elements: ");
		for (Integer element : list) {
			System.out.print(element + " ");
		}
		System.out.println();
		list.clear();
		System.out.println("Size after clearing: " + list.size()); // Size after clearing: 0
		System.out.println("Is empty: " + list.isEmpty()); // Is empty: true

	}
}

package ait.arraylist.model;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("World");
		list.add("Java");
		list.add("Hello");
		System.out.println(list);
		System.out.println(list.size());
		list.add(1, "AIT");
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println(list.indexOf("Hello"));
		System.out.println(list.lastIndexOf("Hello"));
		System.out.println(list.indexOf("JavaScript"));
		list.remove(2);
		System.out.println(list);
		list.set(1, "Danil");
		System.out.println(list);

	}
}

package ait.arraylist.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main2 {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		words.add("Marsel");
		words.add("Sidikov");
		words.add("29");
		words.add("1.85");
		HashSet<String> names = new HashSet<>();
		names.add("Marsel");
		names.add("Igor");
		names.add("Danil");
		names.add("Marsel");

//		Iterator<String> iterator = words.iterator(); {
//			while (iterator.hasNext()) {
//				System.out.println(iterator.next());
//			}
//
//		}
//		Iterator<String> iterator2 = names.iterator(); {
//			while (iterator2.hasNext()) {
//				System.out.println(iterator2.next());
//			}
//		}
		for (String word : words) {
			System.out.println(word);
		}
		for (String name : names) {
			System.out.println(name);
		}
	}
}

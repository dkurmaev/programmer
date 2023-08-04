package danil.praxis.list;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateWithHashSet {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		int duplicate = generateAndInsertDuplicate(set);
		System.out.println("Дубликат вставленное число: " + duplicate);
	}

	public static int generateAndInsertDuplicate(Set<Integer> set) {
		for (int i = 1; i <= 100; i++) {
			set.add(i);
		}
		int duplicate = (int) (Math.random() * 100) + 1;
		set.add(duplicate);

		return duplicate;
	}
}


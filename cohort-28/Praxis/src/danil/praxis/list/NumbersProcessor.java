package danil.praxis.list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NumbersProcessor {

	public void filter(List<Integer> numbers, Predicate<Integer> integerPredicate) {
		List<Integer> filtered = new ArrayList<>();

		for (Integer number : numbers) {
			if (integerPredicate.test(number)) {
				filtered.add(number);
			}
		}
		return;
	}
}

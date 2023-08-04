package ait.pet.test;

import ait.pet.model.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class CatTest {

	Cat[] cats;

	@BeforeEach
	void setUp() {
		cats = new Cat[]{
				new Cat("Belka", 4, "red", 3),
				new Cat("Strelka", 5, "white", 6),
				new Cat("Tom", 5, "grey", 7),
				new Cat("Jerry", 6, "brown", 5)
		};
	}

	@Test
	void testCatsSort() {
		System.out.println("=================TestCatsUnSorted==================");
		printArray(cats);
		System.out.println("==================TestCatsSorted===================");
		Arrays.sort(cats);
		printArray(cats);

		// Создание компаратора для сортировки по цвету в обратном порядке
		Comparator<Cat> catsComparator = new Comparator<Cat>() {
			@Override
			public int compare(Cat o1, Cat o2) {
				return o2.getColor().compareTo(o1.getColor());
			}
		};
		Arrays.sort(cats, catsComparator);
		System.out.println("=============TestCatsSortedComparator==============");
		printArray(cats);

		// Создание компаратора для сортировки
		Arrays.sort(cats, (s1, s2) -> {
			int res = s1.getWeight() - s2.getWeight();// по весу
			if(res !=0) return res;
			return s1.getAge() - s2.getAge();// по возрасту
		});
		System.out.println("=============TestCatsSortedByWeight===============");
		printArray(cats);
	}

	// Метод для вывода элементов массива
	public void printArray(Object[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

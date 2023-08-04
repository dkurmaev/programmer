package ait.wardrobe.test;

import ait.wardrobe.model.Wardrobe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class WardrobeTest {
	private static final int SIZE = 10;
	private static final int MAX = 5;

	private static Random random = new Random();
	Wardrobe[] wardrobes;

	@BeforeEach
	void setUp() {
		wardrobes = getWardrobes();
	}

	private Wardrobe[] getWardrobes() {
		Wardrobe[] res = new Wardrobe[SIZE];
		for (int i = 0; i < res.length; i++) {
			double height = 1 + random.nextInt(MAX);
			double width = 1 + random.nextInt(MAX);
			double depth = 1 + random.nextInt(MAX);
			res[i] = new Wardrobe(height, width, depth);
		}
		return res;
	}

	private void printArray(Wardrobe[] wardrobes, String title) {
		System.out.println("============================" + title + "===============================");
		for (int i = 0; i < wardrobes.length; i++) {
			System.out.println(wardrobes[i].toString());
		}
	}

	@Test
	void testComparableWardrobe() {
		printArray(wardrobes, "Test Comparable before sort: ");
		Arrays.sort(wardrobes);
		printArray(wardrobes, "Test Comparable after sort: ");
		int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1));
		System.out.println("Index = " + index);
	}

	@Test
	void testAreaComparatorWardrobe() {
		printArray(wardrobes, "Test Area Comparator before sort: ");
		Comparator<Wardrobe> comparator = (w1, w2) -> Double.compare(w1.area(), w2.area());
		Arrays.sort(wardrobes, comparator);
		printArray(wardrobes, "Test Area Comparator after sort: ");
		int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1));
		System.out.println("Index = " + index);
	}
	@Test
	void testVplumeComparatorWardrobe() {
		printArray(wardrobes, "Test Volume Comparator before sort: ");
		Comparator<Wardrobe> comparator = (w1, w2) -> Double.compare(w1.volume(), w2.volume());
		Arrays.sort(wardrobes, comparator);
		printArray(wardrobes, "Test Volume Comparator after sort: ");
		int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1));
		System.out.println("Index = " + index);
	}
	@Test
	void testHeightVolumeWardrobe(){
		printArray(wardrobes, "Test Height Volume Comparator before sort: ");
		Comparator<Wardrobe> comparator = (w1, w2) -> {
			int res = Double.compare(w1.getHeight(), w2.getHeight());
			return res !=0 ? res : Double.compare(w1.volume(), w2.volume());
		};
		Arrays.sort(wardrobes, comparator);
		printArray(wardrobes, "Test Height Volume Comparator after sort: ");
		int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1));
		System.out.println("Index = " + index);
	}
}

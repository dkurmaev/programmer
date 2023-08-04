package ait.time.test;

import ait.time.util.DateOperation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DateOperationTest {


	@Test
	void getAge() {
		assertEquals(62, DateOperation.getAge("12/04/1961"));
		assertEquals(61, DateOperation.getAge("1961-12-25"));
	}

	@Test
	void sortStringDates() {
		String[] dates = {"2000-12-01", "10/12/2000","1970-08-12","2010-10-05"};
		String[] expected = {"1970-08-12", "2000-12-01", "10/12/2000","2010-10-05"};
		String[] actual = DateOperation.sortStringDates(dates);
		System.out.println("======================= Original ================================");
		System.out.println("Original: " + Arrays.toString(dates));
		assertArrayEquals(expected, actual);
		System.out.println("======================= Expected ================================");
		System.out.println("Expected: " + Arrays.toString(expected));
		System.out.println("======================== Actual =================================");
		System.out.println("Actual: " + Arrays.toString(actual));
		System.out.println("======================= Test Result: ===============================");
		System.out.println("Test Result: " + Arrays.equals(expected, actual));
	}
}
package ait.datesort.test;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.testng.Assert.assertEquals;

public class DateSortTest {

	@Test
	public void testDateSort() {
		String[] dates = { "07-05-1990", "28-01-2010", "11-08-1990", "15-01-2010", "16-06-1970" };

		Arrays.sort(dates, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String[] date1 = s1.split("-");
				String[] date2 = s2.split("-");

				int day1 = Integer.parseInt(date1[0]);
				int month1 = Integer.parseInt(date1[1]);
				int year1 = Integer.parseInt(date1[2]);

				int day2 = Integer.parseInt(date2[0]);
				int month2 = Integer.parseInt(date2[1]);
				int year2 = Integer.parseInt(date2[2]);

				if (year1 != year2) {
					return Integer.compare(year1, year2);
				}
				if (month1 != month2) {
					return Integer.compare(month1, month2);
				}
				return Integer.compare(day1, day2);
			}
		});

		String[] expectedDates = { "16-06-1970", "07-05-1990", "11-08-1990", "15-01-2010", "28-01-2010" };

		assertEquals(dates, expectedDates);

		// Print the sorted array
		for (String date : dates) {
			System.out.println(date);
		}
	}
}

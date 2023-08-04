package ait.weekdays;


import ait.weekdays.model.ArraySum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraySumTest {

	ArraySum arraySum;
	@BeforeEach
	void setUp() {
		arraySum = new ArraySum();

	}
	@Test
	void testSumEllOddInd(){
		int[] arr = {10, 20, -30};
		arraySum.sumElOddInd(arr);
		assertEquals(50,arraySum.sumElOddInd(arr));


	}
}



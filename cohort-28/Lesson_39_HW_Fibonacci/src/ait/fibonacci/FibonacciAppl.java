package ait.fibonacci;

import ait.fibonacci.model.Fibonacci;

public class FibonacciAppl {
	public static void main(String[] args) {
		Fibonacci num = new Fibonacci(8);
		for (Integer i : num) {
			System.out.print(i + "\t");
		}
		System.out.println("\n" + "Sum of all numbers: " + num.getSum());

	}
}

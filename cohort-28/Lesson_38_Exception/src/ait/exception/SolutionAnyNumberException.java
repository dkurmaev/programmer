package ait.exception;

/*
Непроверяемые исключения (unchecked exceptions): Это исключения, которые не требуют обязательной обработки или объявления в сигнатуре метода.
Например, ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException и т.д.
 */
public class SolutionAnyNumberException extends RuntimeException {
	String message;

	public SolutionAnyNumberException() {
		super();
	}

	public SolutionAnyNumberException(String message) {
		super(message);
	}
}
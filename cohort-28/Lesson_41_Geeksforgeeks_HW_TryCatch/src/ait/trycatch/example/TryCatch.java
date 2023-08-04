package ait.trycatch.example;

public class TryCatch {
	public static void main(String[] args) {
		int[] arr = new int[4];
		/*
		В блоке try мы пытаемся получить доступ к элементу массива arr по индексу 4,
		хотя массив имеет размер 4 (индексы от 0 до 3). Это вызовет исключение ArrayIndexOutOfBoundsException,
		так как индекс выходит за пределы допустимого диапазона.
		 */
		try {
			int i = arr[4];
			System.out.println("Inside try block");
		}
		/*
		В блоке catch мы перехватываем исключение ArrayIndexOutOfBoundsException и выводим сообщение
		"Exception caught in catch block" (Исключение перехвачено в блоке catch).
		 */
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Exception caught in catch block");
		}
		/*
		В блоке finally содержится код, который будет выполнен всегда, независимо от того,
		произошло исключение или нет. Здесь выводится сообщение "Finally block will execute always" (Блок finally будет выполняться всегда).
		 */
		finally {
			System.out.println("Finally block will execute always");
		}

	}
}

package ait.trycatch.example;

public class TryCatch2 {
	public static void main(String[] args) {
		int[]arr = new int[4];
		/*
		В блоке try мы пытаемся получить доступ к элементу массива arr по индексу 4, хотя массив имеет размер 4
		(индексы от 0 до 3). Это вызовет исключение ArrayIndexOutOfBoundsException, так как индекс выходит
		за пределы допустимого диапазона.
		 */
		try {
			int i = arr[4];
			System.out.println("Inside try block");
		}
		/*
		Однако в блоке catch мы указываем перехват исключения NullPointerException, но так как в
		данной ситуации возникает исключение ArrayIndexOutOfBoundsException, то блок catch не
		будет выполнен, и программа перейдет к выводу "За пределами конструкции try-catch".
		 */
		catch (NullPointerException ex){
			System.out.println("Exception has been caught");
		}
		System.out.println("Outside try-catch clause");
	}
}
//За пределами конструкции try-catch
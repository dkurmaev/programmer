package ait.trycatch.example;

public class TryCatch5 {
	public static void main(String[] args) {
		/*
		В блоке try мы пытаемся преобразовать строку "123" в целочисленное значение с помощью метода Integer.parseInt(str).
		 */
		try{
			String str = "123";
			int num = Integer.parseInt(str);
			System.out.println("Try block fully executed");
		}
		/*
		В блоке catch мы указываем перехват исключения NumberFormatException, и если бы возникло исключение, то было бы выведено сообщение "Блок catch выполнен....".
		 */
		catch (NumberFormatException ex){
			System.out.println("Catch block executed....");
		}
		finally {
			System.out.println("Finally block executed....");
		}
		System.out.println("Outside try-catch-finally clause");
	}
}
//Внутри блока try
//За пределами конструкции try-catch
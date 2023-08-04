package ait.trycatch.example;

public class TryCatch4 {
	public static void main(String[] args) {
		/*
		В блоке try мы пытаемся преобразовать строку "123" в целочисленное значение с помощью метода Integer.parseInt(str).
		Этот метод успешно преобразует строку в число, так как "123" является корректным целочисленным значением.
		Если бы вместо "123" была бы некорректная строка, например "abc", то возникло бы исключение NumberFormatException.
		 */
		try {
			String str = "123";
			int num = Integer.parseInt(str);
			System.out.println("Inside try block");
		}
		/*
		В блоке catch мы указываем перехват исключения NumberFormatException, и если бы возникло исключение, то было бы выведено сообщение "Блок catch выполнен....".
		 */
		catch(NumberFormatException ex){
			System.out.println("Catch block executed....");
		}
		System.out.println("Outside try-catch clause");
	}

}
//Внутри блока try
//За пределами конструкции try-catch

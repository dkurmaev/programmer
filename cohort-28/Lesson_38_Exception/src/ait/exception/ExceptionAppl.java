package ait.exception;

public class ExceptionAppl {
	public static void main (String[] args) {
		int a = 3;
		int b = 12;
		try {// попытка выполнить код
			int x = solution(a, b);// инициализирует переменную x результатом выполнения метода solution - это метод ниже
			System.out.println("Solution = " + x);

		} catch (NoSolutionException e) {// если выбрасывается исключение NoSolutionException
//            e.printStackTrace();
//            System.out.println(e.getMessage());
			System.out.println("No solution");// выводит сообщение

		} catch (SolutionAnyNumberException e) {// если выбрасывается исключение SolutionAnyNumberException
//            System.out.println(e.getMessage());
			System.out.println("Solution any number");//

		}  finally {// в любом случае
			System.out.println("Bye, bye");// выводит сообщение
		}
		System.out.println("Math is great");// если исключения не выбрасываются, то выводит сообщение

	}

	public static int solution(int a, int b) throws NoSolutionException {// метод может выбросить исключение нетолько
		int res;// NoSolutionException, но и SolutionAnyNumberException
		if (a == 0 && b != 0) {// если а равно 0 и b не равно 0
			throw new NoSolutionException();// выбрасывает исключение
		}
		if (a == 0 && b == 0) {// если а равно 0 и b равно 0
			throw new SolutionAnyNumberException();// выбрасывает исключение
		}// если а не равно 0
		res = b / a;
		return res;// возвращает результат
	}
}
package danil.praxis.list;

public class FindDuplicateWithoutXOR {
	public static void main(String[] args) {
		int[] arr = new int[101]; // Массив с длиной 101 для хранения чисел от 1 до 100 и дубликата
		int duplicate = generateAndInsertDuplicate(arr); // Вставляем дубликат и находим его

		// Выводим массив в консоль
		System.out.println("Массив: ");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		// Выводим результат (дубликат) в консоль
		System.out.println("Дубликат вставленное число: " + duplicate);
	}

	public static int generateAndInsertDuplicate(int[] arr) {
		// Заполнение массива последовательными натуральными числами от 1 до 100
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = i + 1;
		}

		// Генерация случайного числа для вставки и его позиции в массиве
		int duplicate = (int) (Math.random() * 100) + 1;
		int indexToInsert = (int) (Math.random() * 100) + 1;

		// Вставка дубликата в случайное место в массиве
		arr[indexToInsert] = duplicate;

		// Находим дубликат
		int n = arr.length - 1; // Количество элементов массива (без дубликата)
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		int naturalSum = (n * (n + 1)) / 2;

		return sum - naturalSum;
	}
}

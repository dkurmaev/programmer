//Задан массив целых чисел: 56, 73, 15, -10, 37, -14, 25, 65, 33, 38. Найдите максимальный элемент массива и его индекс.
public class Main {
    public static void main(String[] args) {
        int[] arr = {56, 73, 15, -10, 37, -14, 25, 65, 33, 38};

        int maxElement = arr[0]; // Первый элемент массива принимаем как начальное значение максимального элемента
        int maxIndex = 0; // Индекс первого элемента

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
                maxIndex = i;
            }
        }

        System.out.println("Максимальный элемент: " + maxElement);
        System.out.println("Индекс максимального элемента: " + maxIndex);
    }
}

//Написать метод, принимающий массив целых чисел, и возвращающий среднее арифметическое всех его элементов.
public class Average {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        double average = calculateAverage(array);
        System.out.println("Average: " + average);
    }

    private static double calculateAverage(int[] arr) {
        if (arr.length == 0) {
            return 0; // Если массив пустой, возвращаем 0
        }

        int sum = 0;
        for (int num : arr) {
            sum += num; // Суммируем все элементы массива
        }

        return (double) sum / arr.length; // Возвращаем среднее арифметическое
    }
}

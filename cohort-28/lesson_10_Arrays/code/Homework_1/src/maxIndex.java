//Написать метод, принимающий массив целых чисел, и возвращающий индекс максимального элемента.
public class maxIndex {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 9, 2};
        int maxIndex = findMaxIndex(array);
        System.out.println("Index of the maximum element: " + maxIndex);
    }

    private static int findMaxIndex(int[] arr) {
        int maxIndex = 0; // Предполагаем, что максимальный элемент находится на индексе 0

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i; // Если текущий элемент больше максимального, обновляем индекс максимального элемента
            }
        }

        return maxIndex;
    }
}

//Написать метод, принимающий массив целых чисел, и разворачивающий его.
// Последний элемент становится нулевым, предпоследний, первым, и т. д. Подсказка: этот метод должен изменить полученный массив
public class MainReverseArray_1 {
    public static void main(String[] args) {
        System.out.println("Print reversed array: ");
        int[] myarray = {56, 73, 15, -10, 37, -14, 25, 65, 33, 38};
        // объявили массив целых чисел+

        printArrayReverce(myarray);
    }
    public static void printArrayReverce(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) { // пробегаем от последнего индекса до 0-го, arr.length - 1 это номер последнего, i-- это
            System.out.print(arr[i] + "\t"); // "\t" - это символ табуляции, между элементами массива на печати будет расстояние
        }
        System.out.println(); // переход на новую строку
    }
}
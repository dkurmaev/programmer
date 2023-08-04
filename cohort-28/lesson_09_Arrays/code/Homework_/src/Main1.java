//Создайте массив из 20 случайных целых чисел в интервале от 10 до 20.
// Выведите массив на печать.
// Поменяйте местами первый и последний элементы массива и снова выведите массив на печать.
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Search element in array.");
        int[] array = new int[20];
        int b = 12;
        int a = 17;

    // Заполняем массив случайными числами в интервале от 10 до 20
    //выполняет итерацию от i = 0 до i < array.length (длина массива array).
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (b - a + 1) + a);
        }
        int x = 0;
        x = array[0];                                              //сохраняем значение первого элемента массива в переменную x.
        System.out.println("First = " + x);                        //сохраняем значение первого элемента массива в переменную x.
        System.out.println("Second = " + array[array.length - 1]);//выводим на экран значение первого элемента (x) и последнего элемента (array[array.length - 1]).
        System.out.println(Arrays.toString(array));               //выводим на экран содержимое массива с помощью Arrays.toString(array)
    // Переставляем первый и последний элементы массива
        reversElement(array);                                     //метод reversElement(array), который переставляет первый и последний элементы массива.
        System.out.println(Arrays.toString(array));               //выводим на экран обновленное содержимое массива
    }
    //_______________Method__________________
    private static void reversElement(int[] arr) {

        // Используем цикл для перестановки элементов массива
        for (int i = 0; i < arr.length / 2; i++) {                //Здесь i итерируется от 0 до arr.length / 2 - 1, что означает, что мы переставляем элементы только до середины массива.
            int temp = arr[i];                                    //значение текущего элемента arr[i] во временную переменную temp.
            arr[i] = arr[arr.length - 1 - i];                    // присваиваем текущему элементу значение элемента, находящегося на противоположном конце массива
            arr[arr.length - 1 - i] = temp;                     //присваиваем элементу на противоположном конце массива значение temp, которое было сохранено ранее
        }
    }
}
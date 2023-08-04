//Написать метод, принимающий массив целых чисел, и возвращающий сумму всех его нечетных элементов
public class Main3 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        //обьявление массива
        //присваевается значения массива
        arr[0] = 12;
        arr[1] = -7;
        arr[2] = -5;
        arr[3] = 5;
        arr[4] = -8;
        arr[5] = -9;
        arr[6] = 25;
        arr[7] = 3;
        arr[8] = 17;
        arr[9] = 52;
        int [] abc = {1, 2, 3, 5, 4, 6, 7, 9, 11, 12, 18, 17};

        int s = sumOfEvenElements(arr);// вызываем метод и передаем ему аргументом массив "arr в строке 4"
        int sabc = sumOfEvenElements(abc); // вызываем метод и передаем ему аргументом массив "abc в строке 17"

        System.out.println("Mетод, принимающий массив целых чисел, и возвращающий сумму всех его нечетных элементов:");
        System.out.println();
        System.out.println("Sum of even elements of array is: " + s);
        System.out.println();
        System.out.println("Sum of even elements of abc is: " + sabc);

    }
    //_________Method____________
    public static int sumOfEvenElements(int array[]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                sum = sum + array[i];
            }

        }
        return sum;

    }
    //________End of method______

}
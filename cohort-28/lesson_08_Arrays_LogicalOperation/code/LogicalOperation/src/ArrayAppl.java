public class ArrayAppl {
    public static void main(String[] args) {

//int a;  обьявление переменной
//int [] arr;  представляет собой объявление переменной arr типа "массив целых чисел" в Java
// Квадратные скобки [] указывают, что это массив

        int[] arr = new int[5]; // и это индекс 0,1,2,3,4
        System.out.println(arr[2]);
        arr[2] = 42; //элементу масива с индечксом 2 присвоенно значение 42
        System.out.println(arr[2]);
        arr[1] = arr[2] * 2;
        System.out.println(arr[1]);
        System.out.println(arr.length); // количество индексов в строке т.е. от 0 до 4 это 5
        int[] odds = {1, 3, 5, 7, 9, 11, 13, 15}; // масив с нечетными числами
        System.out.println(odds.length);
        System.out.println(odds[3]);
        odds[2] = -1;
        System.out.println(odds[2]);
        int i = 4;
        System.out.println(odds[i]);
        i++;
        System.out.println(odds[i]);

        for (int j = 0; j < odds.length; j++)
            System.out.println(odds[j]);
        printArray(odds);
        printArray(arr);
        int res = sumArray(odds);
        System.out.println("sum :" + res);

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("=============");
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }
}

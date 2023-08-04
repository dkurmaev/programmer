public class ArraysTools {
    public static void main(String[] args) {
        int[] arr = new int[10];
        fillArray(arr, 10, 99);
        printArray(arr);
        //bubbleSort(arr);
        //printArray(arr);
        bubbleSort1(arr);
        printArray(arr);
        maxArray(arr);
        printArray(arr);
    }




    //Метод printArray вызывается для вывода элементов массива на экран.
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;

                }

            }

        }
    }

    public static void bubbleSort1(int[] arr) {
        boolean flag = bubbling(arr);
        while (flag) ;
        {
            flag = bubbling(arr);
        }
    }

    public static boolean bubbling(int[] arr) {
        boolean flag = false;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int t = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = t;
                flag = true;
            }
        }
        return flag;
    }

    //Метод fillArray вызывается для заполнения массива случайными значениями в диапазоне от min до max.
    public static void fillArray(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            //функция Math.random(), генерирует случайное число от 0 до 1.
            // Путем умножения на (max + 1 - min) и прибавления min получаем случайное число в заданном диапазоне.
            arr[i] = (int) (min + Math.random() * (max + 1 - min));

        }
    }

    public static int maxArray(int[] arr) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (res < arr[i]) {
                res = arr[i];
            }
        }
        return res;
    }
}








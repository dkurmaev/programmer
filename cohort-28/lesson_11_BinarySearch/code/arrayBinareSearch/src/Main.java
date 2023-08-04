import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Binary search ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input element to search: ");

        int element = scanner.nextInt();//read searched element from user

        int[] numbers = {-4, 1, 10, 11, 13, 20, 35, 46, 56, 67};// нужен отсортированный(!!!) массив
        System.out.println(Arrays.toString(numbers)); // print array

        //Алгоритм:
        //левый left - левый конец массива(index)
        //правый right - правый конец массива(index)
        //серидина массива middle - середина массива, middle = left + (right - left)/2; или (array.length / 2)
        //пока левый <= правый будем делать
        //искать элемент в левой или правой половине
        //"сделать" новые left и right в зависимости от того, где искомый элемент

        int[] res = mySearch(numbers, element); // Выполняем бинарный поиск

        // Выводим результат поиска
        if (res[0] != -1){
            System.out.println("Index found " + res[0] + ", element value: " + res[1]);
        } else {
            System.out.println("Element not found.");
        }
    }

        public static int[] mySearch(int[] numbers, int element){
            int left = 0;
            int right = numbers.length - 1;
            int middle = left + (right - left) / 2;

            while (left <= right) {
                if (element < numbers[middle]) {// element in left part
                    right = middle - 1;
                } else if (element > numbers[middle]) {// element in right part
                    left = middle + 1;
                } else { // element is finded
                   return new int[]{middle, numbers[middle]};
                }

                middle = left + (right - left)/2;// new middle

        }

        return new int[]{-1, -1}; // element not found


    }
}
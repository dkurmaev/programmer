public class ArrayAdvAppl {
    public static void main(String[] args) {
        int[] arr = new int[10];//int[] arr - это stack, new int[10] - это heap
        printArray(arr);
        fillArray(arr, 10, 99);
        printArray(arr);

    //min and max include
    }
    public static void fillArray(int[] arr, int min, int max){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (min + Math.random() * (max + 1));

        }
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
package try_catch_example;

public class ArrayOutOfRange {
	public static void main(String[] args) {

		//есть массив из 5 элементов, пытаемся обратиться к 6-му
		int[] arr = new int[5];
		int[] arr2 = {23,16,18,15,7};
		System.out.println(arr2[4]);
		try {
			arr[6] = 5;
			arr2[6] = 5;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

	}
}

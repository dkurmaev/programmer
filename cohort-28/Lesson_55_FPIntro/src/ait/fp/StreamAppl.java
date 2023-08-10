import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAppl {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(List.of(1, 9, 2, 8, 3, 7, 4, 6, 5));
		list.stream()
				.filter(x -> x > 3)
				.peek(x -> System.out.println("Filtered value: " + x))
				.sorted()
				.forEach(System.out::println);
		Integer[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5};
		Stream<Integer> streamInt = Arrays.stream(arr)
				.filter(x -> x > 2)
				.filter(x -> x % 2 == 0)
				.peek(x -> System.out.println("Filtered value: " + x))
				.sorted((x, y) -> Integer.compare(y, x));
		streamInt.forEach(System.out::println);
		System.out.println("===================");
		int sum = Arrays.stream(arr)
				.map(x -> x * 10)
				.reduce(0, (accum, x) -> x + accum);
		System.out.println("sum = " + sum);
		System.out.println("===================");
		int mul = Arrays.stream(arr)
				.map(x -> x * 10)
				.reduce(1, (accum, x) -> x * accum);
		System.out.println("mul = " + mul);
		System.out.println("===================");
		String str = Arrays.stream(arr)
				.sorted()
				.map(x -> x.toString())
				.reduce("", (y, x) -> y + x + " ");
		System.out.println("Result = " + str);

	}
}
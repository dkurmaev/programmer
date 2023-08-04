package danil.praxis.list;

import java.util.ArrayList;
import java.util.Random;

public class FindDuplicateRandom {
	public static void main(String[] args) {
		Random random = new Random();
		int randomInt = random.nextInt(100);
		int randomIndex = random.nextInt(100);
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			arr.add(i);
		}
		arr.add(randomIndex, randomInt);
		System.out.println(arr);
		System.out.println(findDuplicate(arr));
	}
	public static int findDuplicate(ArrayList<Integer> arr) {
		int x = 0;
		for (Integer i : arr ){
			if (i != x){
				return i;
			}
			x++;
		}
		return -1;
	}



}

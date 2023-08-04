package danil.praxis.list;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 100 ; i++) {
			list.add(i);

		}
		list.add(21,6);
		System.out.println(list);
		System.out.println(findDuplicate(list));
	}
	public static int findDuplicate(List<Integer> list){
		int duplicate = 0;
		for(int i = 0; i < list.size(); i++){
			if(list.indexOf(list.get(i)) != list.lastIndexOf(list.get(i))){
				duplicate = list.get(i);
				break;
			}
		}
		return duplicate;
	}
}

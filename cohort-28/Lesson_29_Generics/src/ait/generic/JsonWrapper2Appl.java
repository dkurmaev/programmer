package ait.generic;

import ait.generic.utils.JsonWrapper2;

public class JsonWrapper2Appl {
	public static void main(String[] args) {
		JsonWrapper2 <Long> stringJsonWrapper2 = new JsonWrapper2<>(15L);
		System.out.println(stringJsonWrapper2);
		Long a = stringJsonWrapper2.getValue();
		System.out.println(a);
		System.out.println("======================================================");
		JsonWrapper2 <Integer> integerJsonWrapper2 = new JsonWrapper2<>(25);
		System.out.println(integerJsonWrapper2);
		Integer b = integerJsonWrapper2.getValue();
		System.out.println(b);




	}
}

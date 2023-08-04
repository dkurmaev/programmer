/*Программа получает на вход IP-адрес в одну строку: например, 192.168.23.1 (четыре числа, разделённые точками). Каждое число должно быть в диапазоне от 0 до 255. Программа должна вывести эти четыре числа по отдельности.

Идеальное решение: создать Java-класс IPAddress и реализовать в нем метод валидации создаваемого объекта. Альтернативное решение: IP-адрес вводится с клавиатуры, используются самостоятельно разработанные методы.*/
package ait.parsingIp.model;

public class Main {
	public static void main(String[] args) {
		System.out.println("Parsing IP adresse: ");
		String ipAdress = "245.155.300.1";
		int l = ipAdress.length();
		//System.out.println(l);
		checkIP(ipAdress);
		System.out.println(checkIP("136.145.41.0"));
//		int dot1Index = ipAdress.indexOf(".");
//		System.out.println(ipAdress.indexOf('.'));
//		int dot2Index = ipAdress.indexOf(".", dot1Index + 1);
//		System.out.println(dot2Index);
//		int dot3Index = ipAdress.indexOf(".", dot2Index + 1);
//		System.out.println(dot3Index);
//		String p1 = ipAdress.substring(0, dot1Index);
//		System.out.print(p1);
//		String p2 = ipAdress.substring(dot1Index + 1, dot2Index);
//		System.out.println(p2);
//		String p3 = ipAdress.substring(dot2Index + 1, dot3Index);
//		System.out.println(p3);
//		String p4 = ipAdress.substring(dot3Index + 1, l);
//		System.out.println(p1);
//		int one = Integer.parseInt(p1);
//		int two = Integer.parseInt(p2);
//		int three = Integer.parseInt(p3);
//		int four = Integer.parseInt(p4);
//		if (one < 0 || one > 255) {
//			System.out.println("Wrong 1Index IP Adress!");
//			return;
//		}
//		if (two < 0 || two > 255) {
//			System.out.println("Wrong 2Index IP Adress!");
//			return;
//		}
//		if (three < 0 || three > 255) {
//			System.out.println("Wrong 3Index IP Adress!");
//			return;
//		}
//		if (four < 0 || four > 255) {
//			System.out.println("Wrong 4Index IP Adress!");
//			return;
//		}
//		System.out.println(one + "." + two + "." + three + "." + four);
//

	}
	public static boolean checkIP(String ipAdress){
		int l = ipAdress.length();
		//System.out.println(l);
		int dot1Index = ipAdress.indexOf(".");
		//System.out.println(ipAdress.indexOf('.'));
		int dot2Index = ipAdress.indexOf(".", dot1Index + 1);
		//System.out.println(dot2Index);
		int dot3Index = ipAdress.indexOf(".", dot2Index + 1);
		//System.out.println(dot3Index);
		String p1 = ipAdress.substring(0, dot1Index);
		//System.out.print(p1);
		String p2 = ipAdress.substring(dot1Index + 1, dot2Index);
		//System.out.println(p2);
		String p3 = ipAdress.substring(dot2Index + 1, dot3Index);
		//System.out.println(p3);
		String p4 = ipAdress.substring(dot3Index + 1, l);
		//System.out.println(p1);
		int one = Integer.parseInt(p1);
		int two = Integer.parseInt(p2);
		int three = Integer.parseInt(p3);
		int four = Integer.parseInt(p4);
		if (one < 0 || one > 255) {
			System.out.println("Wrong 1Index IP Adress!");
			return false;
		}
		if (two < 0 || two > 255) {
			System.out.println("Wrong 2Index IP Adress!");
			return false;
		}
		if (three < 0 || three > 255) {
			System.out.println("Wrong 3Index IP Adress!");
			return false;
		}
		if (four < 0 || four > 255) {
			System.out.println("Wrong 4Index IP Adress!");
			return false;
		}
		return true;
	}

}

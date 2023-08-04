package ait.parsingIp.model;
import java.util.Scanner;

public class IpCheck {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input IP-adress: ");
		String ipAddress = scanner.nextLine();

		String[] parts = ipAddress.split("\\.");

		if (parts.length != 4) {
			System.out.println("Wrong format IP-adress");
			return;
		}

		for (String part : parts) {
			int number = Integer.parseInt(part);
			if (number < 0 || number > 255) {
				System.out.println("Uncorrect numbers in IP-adress");
				return;
			}
			System.out.print(number);
		}

	}
}
package ait.parsingIp.model;

public class IpAddress {
	public static void main(String[] args) {
		System.out.println("Parsing IP addresses: ");
		String ipAddress1 = "245.155.300.1";
		System.out.println(checkIP(ipAddress1));

		String ipAddress2 = "136.145.41.0";
		System.out.println(checkIP(ipAddress2));
	}

	public static boolean checkIP(String ipAddress) {
		int counter = 0;
		int l = ipAddress.length();
		int indexdot[] = new int[3];
		for (int i = 0; i < l; i++) {
			if (ipAddress.charAt(i) == '.') {
				indexdot[counter] = i;
				counter++;
			}
		}

		String p1 = ipAddress.substring(0, indexdot[0]);
		String p2 = ipAddress.substring(indexdot[0] + 1, indexdot[1]);
		String p3 = ipAddress.substring(indexdot[1] + 1, indexdot[2]);
		String p4 = ipAddress.substring(indexdot[2] + 1, l);
		int one = Integer.parseInt(p1);
		int two = Integer.parseInt(p2);
		int three = Integer.parseInt(p3);
		int four = Integer.parseInt(p4);

		if (one < 0 || one > 255) {
			System.out.println("Wrong 1st Index IP Address!");
			return false;
		}
		if (two < 0 || two > 255) {
			System.out.println("Wrong 2nd Index IP Address!");
			return false;
		}
		if (three < 0 || three > 255) {
			System.out.println("Wrong 3rd Index IP Address!");
			return false;
		}
		if (four < 0 || four > 255) {
			System.out.println("Wrong 4th Index IP Address!");
			return false;
		}

		return true;
	}
}

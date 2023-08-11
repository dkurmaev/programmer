package danil.RWTHUniversity;

public class Arrays {
    public static void main(String[] args) {
        double doubleArray[];
        String stringArray[];

        doubleArray = new double[3];
        stringArray = new String[4];

        doubleArray[0] = 1.5;
        doubleArray[1] = 1.4;
        doubleArray[2] = -12.3;

        stringArray[0] = "Ar";
        stringArray[1] = "ra";
        stringArray[2] = "y";
        stringArray[3] = "s";

        System.out.println("String array:");
        System.out.println("============================");


        System.out.println("0 | " + stringArray[0]);
        System.out.println("1 | " + stringArray[1]);
        System.out.println("2 | " + stringArray[2]);
        System.out.println("3 | " + stringArray[3]);

        System.out.println("Double array:");
        System.out.println("============================");


        System.out.println("0 | " + doubleArray[0]);
        System.out.println("1 | " + doubleArray[1]);
        System.out.println("2 | " + doubleArray[2]);

    }
}



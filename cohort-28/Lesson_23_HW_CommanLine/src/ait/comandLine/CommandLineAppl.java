package ait.comandLine;

public class CommandLineAppl {
    public static void main(String[] args) {
        if (args.length == 0) {
            displayAllTypes();
        } else if (args.length != 4) {
            System.out.println("Wrong number of arguments");
        } else {
            displayTypeInfo(args);
        }
    }

    private static void displayTypeInfo(String[] args) {
        try {
            byte byteValue = Byte.parseByte(args[0]);
            int intValue = Integer.parseInt(args[1]);
            double doubleValue = Double.parseDouble(args[2]);
            char charValue = args[3].charAt(0);

            //System.out.println("byte: min = " + Byte.MIN_VALUE + ", max = " + Byte.MAX_VALUE);
            //System.out.println("int: min = " + Integer.MIN_VALUE + ", max = " + Integer.MAX_VALUE);
           // System.out.println("double: min = " + Double.MIN_VALUE + ", max = " + Double.MAX_VALUE);
            System.out.println("char: min = " + Character.MIN_VALUE + ", max = " + Character.MAX_VALUE);
        } catch (NumberFormatException e) {
            System.out.println("Wrong type");
        }
    }

    private static void displayAllTypes() {
        System.out.println("byte: min=" + Byte.MIN_VALUE + ", max=" + Byte.MAX_VALUE);
        System.out.println("int: min=" + Integer.MIN_VALUE + ", max=" + Integer.MAX_VALUE);
        System.out.println("double: min=" + Double.MIN_VALUE + ", max=" + Double.MAX_VALUE);
        System.out.println("char: min=" + Character.MIN_VALUE + ", max=" + Character.MAX_VALUE);
    }
}

package ait.wrapper;

public class CommandLineApp {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided. Displaying all types.");
            displayByteRange();
            displayIntRange();
            displayDoubleRange();
            displayCharRange();
        } else {
            for (String arg : args) {
                try {
                    if (arg.equalsIgnoreCase("byte")) {
                        displayByteRange();
                    } else if (arg.equalsIgnoreCase("int")) {
                        displayIntRange();
                    } else if (arg.equalsIgnoreCase("double")) {
                        displayDoubleRange();
                    } else if (arg.equalsIgnoreCase("char")) {
                        displayCharRange();
                    } else {
                        System.out.println("Wrong type: " + arg);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid value for type " + arg);
                }
            }
        }
    }

    private static void displayByteRange() {
        System.out.println("Byte: min=" + Byte.MIN_VALUE + ", max=" + Byte.MAX_VALUE);
    }

    private static void displayIntRange() {
        System.out.println("Int: min=" + Integer.MIN_VALUE + ", max=" + Integer.MAX_VALUE);
    }

    private static void displayDoubleRange() {
        System.out.println("Double: min=" + Double.MIN_VALUE + ", max=" + Double.MAX_VALUE);
    }

    private static void displayCharRange() {
        System.out.println("Char: min=" + Character.MIN_VALUE + ", max=" + Character.MAX_VALUE);
    }
}


package App.Rech;

public class calculatorAppRech {
    public static double calculator(double x, double y, String oper) {
        double result = 0.0;

        switch (oper) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }

        return result;
    }
}

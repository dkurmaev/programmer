package ait.wrapper;

public class WrapperClassesAppl {
    public static void main(String[] args) {
        int x = 20;
        Integer y = 10;
        System.out.println(x);
        System.out.println(y);
        y += 100;
        System.out.println(y);
        Double pi = 3.14;
        double circleLength = 2 * pi * 10;
        System.out.println(circleLength);
        double a =  10.0 /0;
        if (Double.isFinite(a)){
            System.out.println("Wrong result");
        }else{
            System.out.println(a);
        }
        String str1 = y.toString();
        System.out.println(str1);
        str1 = Integer.toString(x);
        System.out.println(str1);
        str1 = pi.toString();
        System.out.println(str1);
        Boolean check = true;
        System.out.println(check);
        str1 = "false";

    }
}

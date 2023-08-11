package danil.RWTHUniversity;

public class mehrereArrays {
    public static void main(String[] args) {
        int x[];
        double y[];
        char z[];
        String v[];

        x = new int[3];
        y = new double[4];
        z = new char[2];
        v = new String[3];

        x[0] = 12;
        x[1] = 11;
        x[2] = -1;

        y[0] = 1.5;
        y[1] = 1.4;
        y[2] = -12.3;
        y[3] = 2.23;

        z[0] = 'a';
        z[1] = '#';

        v[0] = "Ar";
        v[1] = "ra";
        v[2] = "y";

        System.out.println("x[0]: = " + x[0]);
        System.out.println("y[3]: = " + y[2]);
        System.out.println("z[1]: = " + z[1]);
        System.out.println("v[0]: = " + v[0]);

    }
}

package danil.RWTHUniversity;

public class ArrayFrom1To100 {
    public static void main(String[] args) {
        int i;
        int x[];
        x = new int[100];
        for (int j = 1; j < 101; j++) {
            x[j] = j + 1;
            System.out.println(x[j]);

        }
    }
}

//Бросок кубика с гранями 1, 2, 3, 4, 5, 6
public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 6;
        int kub = (int)(Math.random() * (b - a + 1) + a);

        System.out.println(kub);
    }
}
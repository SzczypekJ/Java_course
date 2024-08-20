package interfaces;

public class StaticClass {
    static {
        System.out.println("static block - This is bad idea to create me!")    ;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static double squareRoot(double number) {
        return Math.sqrt(number);
    }
}

import java.util.Locale;

public class Floatadder {
    public static void main(String[] args) {
        String[] add = "1 1e2 3.0 4.754".split(" ");

        Floatadder.adder(add);
    }
    public static void adder(String[] args) {
        int numargs = args.length;

        if (numargs < 2) {
            System.out.println("You need to pass at least two arguments");
        } else {
            float result = 0.0f;
            for (int i = 0; i < numargs; i++) {
                result += Float.parseFloat(args[i]);
            }
            System.out.format(Locale.US, "%.2f%n", result);
        }
    }
}

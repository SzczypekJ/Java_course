//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] add = "1 3 2 10".split(" ");

        Main.adder(add);
    }
    public static void adder(String[] args) {
        int numargs = args.length;

        if (numargs < 2) {
            System.out.println("You need to pass at least two arguments");
        } else {
            int result = 0;
            for (int i = 0; i < numargs; i++) {
                result += Integer.parseInt(args[i]);
            }
            System.out.println(result);
        }
    }
}


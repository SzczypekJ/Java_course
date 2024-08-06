public class UserInfoApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java UserInfoApp <username>");
            return;
        }

        String username = args[0];

        // Print information about the user
        System.out.println("User Info App");
        System.out.println("Hello, " + username + "!");
    }
}

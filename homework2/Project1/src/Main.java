public class Main {
    public static void main(String[] args) {
        // Create a new Phone object representing an iPhone 15 with a specific phone number
        Phone iphone = new Phone("Iphone 15", 676_888_555);

        // Create a new Customer object representing Michal Kowalski, age 30
        Customer Michal = new Customer("Michal", "Kowalski", 30);

        // Create a new Worker object representing a worker named Jakub
        Worker worker = new Worker("Jakub");

        // Create a new Display object with a resolution of 1024x768
        Display display = new Display(1024, 768);

        // Create a new NetworkOperator object representing the T-mobile operator
        NetworkOperator networkOperator = new NetworkOperator("T-mobile");

        // Michal buys the iPhone
        Michal.buyPhone(iphone);

        // Set the iPhone as Michal's phone
        Michal.setPhone(iphone);

        // Set the display for the iPhone
        iphone.setDisplay(display);

        // Set the network operator for the iPhone
        iphone.setNetOperator(networkOperator);

        // Print the worker's name
        System.out.println(worker.getName());

        // Print the phone number of the iPhone
        System.out.println("Phone number: " + iphone.getNumber());

        // Print the network operator name for the iPhone
        System.out.println("Network operator: " + iphone.getNetOperator());

        // Ask the network operator something using the iPhone
        networkOperator.askSomething(iphone);

        // The worker repairs the iPhone
        worker.repair(iphone);

        // Michal checks the network operator of the phone
        Michal.checkPhoneNetwork();

        // Michal makes a call using the iPhone to a specific number
        Michal.makeCall(123456789);
    }
}

package Inheritance;

import PhoneEncapsulation.*;

public class Main {

    public static void main(String[] args) {
        // Create an instance of Iphone
        Iphone iphone = new Iphone(665_222_987);

        // Create instances of other necessary classes
        NetworkOperator plusNet = new NetworkOperator("Plus");
        Display display = new Display(1200, 1000);

        // Set network operator for the iPhone
        iphone.setNetOperator(plusNet);
        System.out.println("Network Operator: " + iphone.getNetOperator());

        // Display iPhone details
        iphone.tellAboutYourself();
        iphone.setDisplay(display);
        System.out.println("Display has the following height and width: " + iphone.getDisplay());

        // Create instances of ElectronicDevices subclasses
        ElectronicDevices tv = new TV("TV");
        ElectronicDevices computer = new Computer("MacBook Pro");
        ElectronicDevices tablet = new Tablet("iPad");
        // This is bad approach when we are inheritance from another class but this still working
        TV tv1 = new TV("TV");

        // Objects for testing
        ElectronicDevices tv2 = new TV("TV");
        Tablet tablet1 = new Tablet("iPad");

        // Create a new Display object for tablet1
        Display displayTablet = new Display(2000, 1500);
        tablet1.setDisplay(displayTablet);

        // Set colors and brand and calculate prices for each device
        // Test case for TV
        tv.setColor("black");
        tv.setBrand("Sony");
        tv.calculatePrice();
        System.out.println(tv);

        // Test case for Computer
        computer.setColor("red");
        computer.setBrand("Dell");
        computer.calculatePrice();
        System.out.println(computer);

        // Test case for Tablet
        tablet.setColor("white");
        tablet.setBrand("Apple");
        tablet.calculatePrice();
        System.out.println(tablet);

        // Additional test case for Tablet1
        tablet1.setColor("black");
        tablet1.setBrand("Lenovo");
        tablet1.setDisplay(display);
        tablet1.calculatePrice();
        System.out.println(tablet1);

        // Use polymorphism: the same method call works with different subclasses
        doSmth(tv);
        doSmth(computer);
        doSmth(tablet);
        doSmth(tv1);
        doSmth(tablet1);

        // Comparing objects using equals method
        System.out.println("If the tv is equal to tv2? " + tv.equals(tv2));
        System.out.println("If the tv1 is equal to tv2? " + tv1.equals(tv2));
        System.out.println("If the tablet is equal to tablet1? " + tablet.equals(tablet1));

        // Test hash codes
        System.out.println("Hash code of tv: " + tv.hashCode());
        System.out.println("Hash code of tv2: " + tv2.hashCode());
        System.out.println("Hash code of tv1: " + tv1.hashCode());
        System.out.println("Hash code of tablet: " + tablet.hashCode());
        System.out.println("Hash code of tablet1: " + tablet1.hashCode());

        // Test if hash codes match for equal objects
        System.out.println("If the tv and tv2 have the same hash code? " + (tv.hashCode() == tv2.hashCode()));
        System.out.println("If the tv1 and tv2 have the same hash code? " + (tv1.hashCode() == tv2.hashCode()));
        System.out.println("If the tablet and tablet1 have the same hash code? " + (tablet.hashCode() == tablet1.hashCode()));


        // Display device info using polymorphism
        displayAllDeviceInfo(tv);
        displayAllDeviceInfo(computer);
        displayAllDeviceInfo(tablet);
        displayAllDeviceInfo(tv1);
        displayAllDeviceInfo(tablet1);
    }

    // Polymorphism example: this method can accept any ElectronicDevices object
    public static void doSmth(ElectronicDevices electronicDevice) {
        // Calls the overridden method in the respective subclass
        electronicDevice.saySmth();
    }

    // Use polymorphism to display device info
    public static void displayAllDeviceInfo(ElectronicDevices device) {
        device.displayDeviceInfo();
    }
}

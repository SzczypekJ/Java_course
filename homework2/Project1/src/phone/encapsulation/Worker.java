package phone.encapsulation;

public class Worker {

    private String name;

    // Constructor that initializes the PhoneEncapsulation.Worker object with a specified name.
    // If the provided name is null or empty, the name is set to "default".
    public Worker(String name) {
        if (name == null || name.length() < 1) {
            this.name = "default";
            System.out.println("Name cannot be empty");
        } else {
            this.name = name;
        }
    }
    // Default constructor that sets the PhoneEncapsulation.Worker's name to "default".
    public Worker() {
        this.name = "default";
    }

    // Method that simulates repairing a phone.
    public void repair(Phone phone) {
        System.out.println("PhoneEncapsulation.Phone " + phone.getModel() + " is being repaired by worker " + this.name );
    }

    // Below are setters and getters:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                '}';
    }
}

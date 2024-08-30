package phone.encapsulation;

public class Customer {
    private String firstName;
    private String lastName;
    private int age;

    // Create an object of class PhoneEncapsulation.Phone
    private Phone phone;

    // Constructor of the PhoneEncapsulation.Customer class
    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Method which allows us to buy a phone
    public void buyPhone(Phone phone) {
        this.phone = phone;
        System.out.println("PhoneEncapsulation.Customer " + this.firstName + " " + this.lastName + " has been bought " + phone.getModel());
    }

    // Method which allows us to make a call
    public void makeCall(int number) {
        if (this.phone != null) {
            System.out.println(this.firstName + " is calling " + number + " using " + this.phone.getModel());
        } else {
            System.out.println(this.firstName + " does not have a phone to make a call.");
        }
    }

    // Method which allows us to check the phone network
    public void checkPhoneNetwork() {
        if (this.phone != null && this.phone.getNetOperator() != null) {
            System.out.println(this.firstName + "'s phone is connected to " + this.phone.getNetOperator());
        } else {
            System.out.println(this.firstName + "'s phone is not connected to any network.");
        }
    }

    // Below are setters and getters:
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}

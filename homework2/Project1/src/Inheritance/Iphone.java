package Inheritance;
import PhoneEncapsulation.*;

public class Iphone extends Phone{

    public Iphone(int number) {
        super("Iphone", number);
    }

    public void tellAboutYourself () {
        System.out.println("I am an Iphone class and I am inheritance from Phone class");
    }
}

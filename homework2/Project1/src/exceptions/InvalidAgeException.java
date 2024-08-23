package exceptions;

public class InvalidAgeException extends Exception{

    private int age;

    public InvalidAgeException(int age){
        super("Invalid age provided:" + age);
        this.age = age;
    }

    public InvalidAgeException(String message, int age){
        super(message + ": " + age);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String suggestValidAgeRange() {
        return "Valid age should be between 0 and 120.";
    }

    public boolean isNegativeAge() {
        return age < 0;
    }
}

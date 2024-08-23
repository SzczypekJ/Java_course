package exceptions;

public class InvalidNameException extends Exception{
    private String name;

    public InvalidNameException(String name) {
        this.name = name;
    }

    public InvalidNameException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String suggestValidName(String name) {
        if (name.isEmpty()) {
            return "The name cannot be empty. Please enter a valid name.";
        } else if (!name.matches("[a-zA-Z]+")) {
            return "The name should consist only of letters without numbers or special characters.";
        } else if (name.length() >= 50) {
            return "The name is too long. It should be shorter than 50 characters.";
        } else {
            return "The name is valid.";
        }
    }
}

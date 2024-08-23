package exceptions;

public class InvalidPhoneNumberException extends Exception{
    private String number;

    public InvalidPhoneNumberException(String number) {
        this.number = number;
    }

    public InvalidPhoneNumberException(String message, String number) {
        super(message);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String suggestValidPhoneNumber(String number) {
        if (number.length() != 9) {
            return "Phone number must have 9 digits";
        } else {
            return "Phone number is valid.";
        }
    }
}

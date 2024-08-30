package exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InvalidDataException extends Exception{
    private String data;

    public InvalidDataException(String data) {
        super("Invalid data provided: " + data);
        this.data = data;
    }

    public InvalidDataException(String message, String data) {
        super(message);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean validateDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

package interfaces;
import phone.encapsulation.*;

public final class FinalPhoneSamsung extends Phone{
    // This static int and final static int
    public static int numberOfOccurances;
    public static final int MAX_NUMBER_OF_PHONES = 6;

    public FinalPhoneSamsung(String model, int number) {
        if (numberOfOccurances >= MAX_NUMBER_OF_PHONES) {
            throw new RuntimeException("Cannot create more than" + MAX_NUMBER_OF_PHONES + " phones");
        }
        numberOfOccurances++;
        super(model, number);
    }

    public void tellAboutYourself () {
        System.out.println("I am a Samsung final class and I am inheritance from Phone class.\n" +
                            "No one can inheritance from my class");
    }

    public final void finalMethod() {
        System.out.println("This is a final method.");
    }
}

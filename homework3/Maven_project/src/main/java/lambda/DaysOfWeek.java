package lambda;

import java.util.Objects;

public enum DaysOfWeek {
    MONDAY("Really bad day"),
    TUESDAY("Not good day"),
    WEDNESDAY("Okey"),
    THURSDAY("Almost weekend"),
    FRIDAY("Party time!"),
    SATURDAY("Party Time!"),
    SUNDAY("End of the weekend");

    private final String description;

    DaysOfWeek(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void theBestDayOfTheWeek() {
        if (this == FRIDAY || this == SATURDAY) {
            System.out.println("The best day of the week is " + this.name());
        } else {
            System.out.println(this.name() + " is not the best day of the week.");
        }
    }
}

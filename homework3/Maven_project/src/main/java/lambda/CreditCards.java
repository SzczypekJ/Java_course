package lambda;

public enum CreditCards {

    VISA("Visa", "The best card"),
    NEW("New", "New"),
    MASTER_CARD("ms", "Good card");

    private final String title;
    private final String description;

    CreditCards(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

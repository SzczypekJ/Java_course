package lambda;

public enum Banks {
    MILENIUM("Milenium", CreditCards.VISA, "Okey bank", 1000),
    PEKAO("Pekao", CreditCards.MASTER_CARD, "Good bank", 2000),
    ALIOR_BANK("Alior Bank", CreditCards.NEW, "Mid bank", 800),
    MBANK("Mbank", CreditCards.MASTER_CARD, "Best bank", 2500);

    private final String name;
    private final CreditCards creditCards;
    private final String description;
    private final int maxAmountOfMoney;

    Banks(String name, CreditCards creditCards, String description, int maxAmountOfMoney) {
        this.name = name;
        this.creditCards = creditCards;
        this.description = description;
        this.maxAmountOfMoney = maxAmountOfMoney;
    }

    public CreditCards getCreditCards() {
        return creditCards;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxAmountOfMoney() {
        return maxAmountOfMoney;
    }

    public String getName() {
        return name;
    }
}

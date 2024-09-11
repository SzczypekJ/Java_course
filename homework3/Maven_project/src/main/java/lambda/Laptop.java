package lambda;

public enum Laptop {

    ASUS("Asus", Battery.HIGH_POWER),
    ACER("Acer", Battery.LOW_POWER);

    private final String name;
    private final Battery battery;

    Laptop(String name, Battery battery) {
        this.name = name;
        this.battery = battery;
    }

    public String getName() {
        return name;
    }

    public Battery getBattery() {
        return battery;
    }
}

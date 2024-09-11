package lambda;

public enum Battery {

    LOW_POWER(250){
        @Override
        public int improve() {
            return 1;
        }
    },
    HIGH_POWER(750);

    private final int power;

    Battery(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int improve() {
        System.out.println("I can do it");
        return 0;
    }
}

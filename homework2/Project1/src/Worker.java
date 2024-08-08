public class Worker {

    String name;

    public Worker(String name) {
        if (name == null || name.length() < 1) {
            this.name = "default";
            System.out.println("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public Worker() {
        this.name = "default"; // Przypisz domyślną nazwę
    }

    public void repair(Phone phone) {
        System.out.println("Phone " + phone.getModel() + " is being repaired.");
    }
}

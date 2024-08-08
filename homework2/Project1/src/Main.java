//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Phone iphone = new Phone("Iphone 15", 6);

        Worker worker = new Worker("Jakub");
        System.out.println(worker.name);

        worker.repair(iphone);
    }
}
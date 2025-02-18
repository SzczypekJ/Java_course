package com.solvd.patterns;

public class Main {
    public static void main(String[] args) {

        // Usage of Factory design pattern:
        Factory factory = new Factory();

        Shape circle = factory.getShape("circle");
        Shape rectangle = factory.getShape("rectangle");
        Shape square = factory.getShape("square");

        System.out.println("Usage of Factory:");
        circle.draw();
        rectangle.draw();
        square.draw();


        // Usage of Abstract Factory:
        AbstractFactory shapeFactory = FacotryGenerator.getFactory("shape");
        AbstractFactory animalFactory = FacotryGenerator.getFactory("animal");

        Shape circle1 = shapeFactory.getShape("circle");
        Shape rectangle1 = shapeFactory.getShape("rectangle");
        Shape square1 = shapeFactory.getShape("square");

        Animal dog = animalFactory.getAnimal("dog");
        Animal cat = animalFactory.getAnimal("cat");
        Animal fish = animalFactory.getAnimal("fish");

        System.out.println("\nUsage of Abstract Factory:");
        circle1.draw();
        rectangle1.draw();
        square1.draw();
        dog.speak();
        cat.speak();
        fish.speak();


        // Usage of Builder pattern:
        Person person = Person.builder()
                .firstName("Jakub")
                .lastName("Szczypek")
                .phone("123456789")
                .age(24)
                .email("example@gmail.com")
                .city("Cracow")
                .address("Example Street")
                .gender("Male")
                .build();

        System.out.println("\nUsage of Builder:");
        System.out.println(person);

        // Usage of Strategy design pattern:
        PaymentContext paymentContext = new PaymentContext();

        System.out.println("\nUsage of Strategy pattern:");

        paymentContext.setPaymentStrategy(new CreditCardPayment("123456789"));
        paymentContext.executePayment(199.99);

        paymentContext.setPaymentStrategy(new PayPalPayment("example@gmail.com"));
        paymentContext.executePayment(99.99);

        paymentContext.setPaymentStrategy(new CryptoPayment("0xABCDEF123456789"));
        paymentContext.executePayment(0.005);
    }
}

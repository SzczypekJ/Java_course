package interfaces;

public class Main {
    public static void main(String[] args) {
        // All interfaces is being tested in inheritance package in file Main !!!!!!!
        // Here I will test a final and static class, methods, variables
        try {
            FinalPhoneSamsung phone1 = new FinalPhoneSamsung("Galaxy S21", 123456);
            System.out.println(FinalPhoneSamsung.numberOfOccurances);
            System.out.println(FinalPhoneSamsung.MAX_NUMBER_OF_PHONES);

            FinalPhoneSamsung phone2 = new FinalPhoneSamsung("Galaxy S21", 123457);
            System.out.println(FinalPhoneSamsung.numberOfOccurances);
            System.out.println(FinalPhoneSamsung.MAX_NUMBER_OF_PHONES);

            FinalPhoneSamsung phone3 = new FinalPhoneSamsung("Galaxy S21", 123458);
            System.out.println(FinalPhoneSamsung.numberOfOccurances);
            System.out.println(FinalPhoneSamsung.MAX_NUMBER_OF_PHONES);

            FinalPhoneSamsung phone4 = new FinalPhoneSamsung("Galaxy S21", 123459);
            System.out.println(FinalPhoneSamsung.numberOfOccurances);
            System.out.println(FinalPhoneSamsung.MAX_NUMBER_OF_PHONES);

            FinalPhoneSamsung phone5 = new FinalPhoneSamsung("Galaxy S21", 123460);
            System.out.println(FinalPhoneSamsung.numberOfOccurances);
            System.out.println(FinalPhoneSamsung.MAX_NUMBER_OF_PHONES);

            FinalPhoneSamsung phone6 = new FinalPhoneSamsung("Galaxy S21", 123461);
            System.out.println(FinalPhoneSamsung.numberOfOccurances);
            System.out.println(FinalPhoneSamsung.MAX_NUMBER_OF_PHONES);
            
            phone1.tellAboutYourself();
            phone1.finalMethod();

            // This will throw an exception
//            FinalPhoneSamsung phone7 = new FinalPhoneSamsung("Galaxy S21", 123462);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        // Testing the static class
        int sum = StaticClass.add(5, 3);
        System.out.println("Sum: " + sum);
        double root = StaticClass.squareRoot(16);
        System.out.println("Square root: " + root);

        StaticClass staticClass = new StaticClass();
        // The code below will not working
//        staticClass.add(5, 10);
    }
}

package interfaces;

public interface Callable {
    void callToSomeone();

    default void WhatICanDoCall () {
        System.out.println("I can call to someone");
    }

    void tellSmth();
}

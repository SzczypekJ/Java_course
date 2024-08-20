package interfaces;

public interface Watchable {
    void watchSmth();

    default void WhatICanDoWatch () {
        System.out.println("I can watch some movie");
    }

    void tellSmth();
}

package interfaces;

public interface MusicListener {
    void listenMusic();

    default void WhatICanDoMusic () {
        System.out.println("I can listening the music");
    }

    void tellSmth();
}

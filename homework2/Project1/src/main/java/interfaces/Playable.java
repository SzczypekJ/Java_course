package interfaces;

public interface Playable {
    void playingGames();

    default void WhatICanDoPlay () {
        System.out.println("I can playing games");
    }

    void tellSmth();
}

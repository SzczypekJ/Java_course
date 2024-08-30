package interfaces;

public interface SocialMediaAccess {
    void socialMediaAccess();

    default void WhatICanDoSocial () {
        System.out.println("I can access to social media");
    }

    void tellSmth();
}

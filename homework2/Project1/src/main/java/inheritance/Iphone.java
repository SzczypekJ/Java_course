package inheritance;
import phone.encapsulation.Phone;
import interfaces.*;


public class Iphone extends Phone implements Callable, MusicListener, Playable, SocialMediaAccess, Watchable{

    public Iphone(int number) {
        super("Iphone", number);
    }

    public void tellAboutYourself () {
        System.out.println("I am an Iphone class and I am inheritance from Phone class");
    }

    @Override
    public void callToSomeone() {
        System.out.println("I am Iphone and I can call to someone normally");
    }

    @Override
    public void listenMusic() {
        System.out.println("I am Iphone and I can listen the music");
    }

    @Override
    public void playingGames() {
        System.out.println("I am Iphone and I can play games");
    }

    @Override
    public void socialMediaAccess() {
        System.out.println("I am Iphone and I can access social media");
    }

    @Override
    public void watchSmth() {
        System.out.println("I am Iphone and I can watch the movie");
    }

    @Override
    public void tellSmth() {
        System.out.println("I am Iphone and I can call to someone normally and do a lot of things.");
    }
}

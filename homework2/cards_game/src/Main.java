//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Test the rankToString method for each rank
        assert Card.rankToString(Card.ACE).equals("Ace");
        assert Card.rankToString(Card.DEUCE).equals("Deuce");
        assert Card.rankToString(Card.THREE).equals("Three");
        assert Card.rankToString(Card.FOUR).equals("Four");
        assert Card.rankToString(Card.FIVE).equals("Five");
        assert Card.rankToString(Card.SIX).equals("Six");
        assert Card.rankToString(Card.SEVEN).equals("Seven");
        assert Card.rankToString(Card.EIGHT).equals("Eight");
        assert Card.rankToString(Card.NINE).equals("Nine");
        assert Card.rankToString(Card.TEN).equals("Ten");
        assert Card.rankToString(Card.JACK).equals("Jack");
        assert Card.rankToString(Card.QUEEN).equals("Queen");
        assert Card.rankToString(Card.KING).equals("King");

        // Test the suitToString method for each suit
        assert Card.suitToString(Card.DIAMONDS).equals("Diamonds");
        assert Card.suitToString(Card.CLUBS).equals("Clubs");
        assert Card.suitToString(Card.HEARTS).equals("Hearts");
        assert Card.suitToString(Card.SPADES).equals("Spades");

        // Create a new card instance and print its string representation
        Card card = new Card(Card.ACE, Card.SPADES);
        System.out.println(card);
    }
}
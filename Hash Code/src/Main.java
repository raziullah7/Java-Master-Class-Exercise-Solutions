import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);

        // first 4 locations return the same hashcode because they
        // have the same strings in them
        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));

        Set<String> mySet = new HashSet<>(hellos);

        // no duplicates
        System.out.println("mySet = " + mySet);
        System.out.println("# of elements = " + mySet.size());

        // cross-checking with list
        for(String val : mySet) {
            System.out.print(val + ": ");
            for(int i = 0; i < hellos.size(); i++) {
                if (val == hellos.get(i)) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println(" ");
        }

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
        cards.forEach(s -> System.out.println(s + ": " + s.hashCode()));
        System.out.println("------------------------------------------");

        Set<PlayingCard> deck = new HashSet<>();

        for (PlayingCard card : cards) {
            if(!deck.add(card)) {
                System.out.println("Found a duplicate for " + card);
            }
        }
        System.out.println("Deck: " + deck);
    }
}
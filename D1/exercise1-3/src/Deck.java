import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    Random random;

    public Deck() {
        this.cards = new ArrayList<>();
        this.random = new Random();

        // create all the cards
        this.generateDeck();
    }

    /*
     * Generate all the cards for a deck
     * the cards are stored in the member variable - cards
     */
    private void generateDeck() {
        final String[] colorName = {"Heart", "Spade", "Diamond", "Club"};
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                this.cards.add(new Card(i, colorName[j]));
            }
        }
    }

    /*
     * Return a random card, remove it from the deck
     */
    public Card getRandomCard() {
        int index = this.random.nextInt(this.cards.size());
        return this.cards.remove(index);
    }

    /*
     * Create a CardGroup by picking 3 cards randomly
     */
    public CardGroup createRandomCardGroup() {
    	Card c1 = getRandomCard();
    	Card c2 = getRandomCard();
    	Card c3 = getRandomCard();
        return new CardGroup(c1, c2, c3);
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        CardGroup cg1 = deck.createRandomCardGroup();
        CardGroup cg2 = deck.createRandomCardGroup();
        CardGroup cg3 = deck.createRandomCardGroup();

        cg1.print();
        cg2.print();
        cg3.print();


        String case1 = cg1.compare(cg2) ? "$1 > $2" : "$1 <= $2";
		String case2 = cg2.compare(cg3) ? "$2 > $3" : "$2 <= $3";
		String case3 = cg1.compare(cg3) ? "$1 > $3" : "$1 <= $3";

		System.out.printf("Compare $1, $2 -> %s \n", case1);
		System.out.printf("Compare $2, $3 -> %s \n", case2);
		System.out.printf("Compare $1, $3 -> %s \n", case3);
    }
}

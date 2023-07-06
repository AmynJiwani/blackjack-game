package coe318.lab5;

import java.util.ArrayList;

/**
 * A pile of cards.
 *
 */
public class CardPile {
//Instance variables

    private ArrayList<Card> cards;

    public CardPile() {
//Initialize the instance variable.
        cards = new ArrayList<Card>();
    }

    /**
     * Add a card to the pile.
     *
     * @param card
     */
    public void add(Card card) {
        this.cards.add(card); //adds the card to the pile
    }

    /**
     * Remove a card chosen at random from the pile.
     *
     * @return
     */
    public Card removeRandom() {
        int num = (int) (Math.random() * this.cards.size());
//System.out.println(num);
        return (this.cards.remove(num)); //removes the prandomly selected card from the pile
    }

    /**
     * The string representation is a space separated list of each card.
     *
     * @return
     */
    @Override
    public String toString() {
        String cardlist = "\n";

        for (Card card : this.cards) {
            cardlist += card.toString() + "\n"; //adds the space to a list of the cards
        }

        return cardlist;
    }

    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
//adds a new card in the following order: rank, suit and in the faceup position respectively
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
//System.out.println(p);
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
//adds the card while declaring the value of faceup to be true (along with declaring the rank and suit)
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i + 1) + ": " + deck.removeRandom());
        }
    }
}

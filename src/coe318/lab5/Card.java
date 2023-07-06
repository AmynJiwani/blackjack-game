package coe318.lab5;

public class Card implements Comparable {
//Symbolic constants

    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    int rankVar, suitVar;
    boolean faceUpVar;

    /**
     * Construct a card of the given rank, suit and whether it is faceup or
     * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
     * have a rank equal to their number. Jack, Queen, King and Ace have the
     * ranks 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3
     * for Clubs, Diamonds, Hearts and Spades respectively.
     *
     * @param rank
     * @param suit
     * @param faceUp
     */
    public Card(int rank, int suit, boolean faceUp) {
//FIX THIS
        rankVar = rank;
        suitVar = suit;
        faceUpVar = faceUp;
    }

    /**
     * @return the faceUp
     */
    public boolean isFaceUp() {
        return faceUpVar; //FIX THIS
    }

    /**
     * @param faceUp the faceUp to set
     */
    public void setFaceUp(boolean faceUp) {
        faceUpVar = faceUp;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rankVar;
    }

    /**
     * @return the suit
     */
    public int getSuit() {
        return suitVar;
    }

    @Override
    public boolean equals(Object ob) {
        if (!(ob instanceof Card)) {
            return false;
        }
        Card c = (Card) ob;
        if (c.rankVar == rankVar && c.suitVar == suitVar) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {//DO NOT MODIFY
        int hash = 7;
        hash = 31 * hash + this.getRank();
        hash = 31 * hash + this.getSuit();
        return hash;
    }

    @Override
    public int compareTo(Object obj) {//DO NOT MODIFY
        return compareTo((Card) obj);
    }

    public int compareTo(Card c) {
        if (this.rankVar < c.rankVar) {
            return -1;
        } else if (this.rankVar > c.rankVar) {
            return 1;
        }

        if (this.suitVar > c.suitVar) {
            return 1;
        } else if (this.suitVar < c.suitVar) {
            return -1;
        } else {
            return 0;
        }
//FIX THIS
    }

    /**
     * Return the rank as a String. For example, the 3 of Hearts produces the
     * String "3". The King of Diamonds produces the String "King".
     *
     * @return the rank String
     */
    public String getRankString() {
        int rank = getRank();
        return switch (rank) {
            case 11 ->
                "Jack";
            case 12 ->
                "Queen";
            case 13 ->
                "King";
            case 14 ->
                "Ace";
            default ->
                Integer.toString(rankVar);
        };
//FIX THIS
    }

    /**
     * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
     *
     * @return the suit String
     */
    public String getSuitString() {
        int suit = getSuit();
        String s = "";
        switch (suit) {
            case 0 ->
                s = "Clubs";
            case 1 ->
                s = "Diamonds";
            case 2 ->
                s = "Hearts";
            case 3 ->
                s = "Spades";
        }
        return (s);//FIX THIS
    }

    public int value() {
        return switch (this.rankVar) {
            case 14 ->
                1;
            case 10 ->
                10;
            default ->
                this.rankVar;
        };

    }

    /**
     * Return "?" if the card is facedown; otherwise, the rank and suit of the
     * card.
     *
     * @return the String representation
     */
    @Override
    public String toString() {
        if (isFaceUp() == true) {
            return "" + getRankString() + " " + getSuitString();
        } else {
            return "?";
        }
    }

    public static void main(String[] args) {
//Create 5 of clubs
        Card club5 = new Card(5, 0, true);
        System.out.println("club5: " + club5);
        Card spadeAce = new Card(14, SPADE, true);
        System.out.println("spadeAce: " + spadeAce);
        System.out.println("club5 compareTo spadeAce: "
                + club5.compareTo(spadeAce));
        System.out.println("club5 compareTo club5: "
                + club5.compareTo(club5));
        System.out.println("club5 equals spadeAce: "
                + club5.equals(spadeAce));
        System.out.println("club5 equals club5: "
                + club5.equals(club5));
    }
}

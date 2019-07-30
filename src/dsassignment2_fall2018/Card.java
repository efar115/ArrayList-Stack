/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsassignment2_fall2018;

/**
 *
 * @author clatulip
 */
public class Card implements Comparable<Card> {

   

    public enum Face {

        JACK, QUEEN, KING, ACE
    }

    public enum Suit {

        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    private boolean faceCard;
    private Suit suit;
    private Face face;

    //Numeric value for suits. Used in compareTo
    private int suitVal;

    //Numeric value for cards
    //2-10 for regular
    //11-14 for face cards and ace
    private int num;

    public Card(Suit suit, Face face) {
        this.setSuit(suit);
        this.setFace(face);
    }

    public Card(Suit suit, int num) {
        this.setSuit(suit);
        this.setNum(num);
    }

    public boolean isFaceCard() {
        return faceCard;
    }

    public Suit getSuit() {
        return suit;
    }

    /*
     Suit enum set
     suitVal changed accordingly
     */
    private void setSuit(Suit suit) {
        this.suit = suit;

        if (suit == Card.Suit.CLUBS) {
            this.suitVal = 1;
        }
        else if (suit == Card.Suit.DIAMONDS) {
            this.suitVal = 2;
        }
        else if (suit == Card.Suit.HEARTS) {
            this.suitVal = 3;
        }
        else if (suit == Card.Suit.SPADES) {
            this.suitVal = 4;
        }
    }

    public Face getFace() {
        return face;
    }

    /*
     Face value changed
     If card was previously not a face card it now will be
     num value set accordingly
     */
    private void setFace(Face face) {
        this.faceCard = true;
        this.face = face;

        if (face == Card.Face.JACK) {
            this.num = 11;
        }
        else if (face == Card.Face.QUEEN) {
            this.num = 12;
        }
        else if (face == Card.Face.KING) {
            this.num = 13;
        }
        else if (face == Card.Face.ACE) {
            this.num = 14;
        }

    }

    public int getNum() {
        return num;
    }

    /*
     If num < 11 set num only
     Else set num and face accordingly
     */
    private void setNum(int num) {
        if (num <= 10) {
            this.num = num;
            this.faceCard = false;
        } else {
            this.faceCard = true;
        }
        if (num == 11) {
            this.setFace(Card.Face.JACK);
            this.num = num;
        }
        else if (num == 12) {
            this.setFace(Card.Face.QUEEN);
            this.num = num;
        }
        else if (num == 13) {
            this.setFace(Card.Face.KING);
            this.num = num;
        }
        else if (num == 14) {
            this.setFace(Card.Face.ACE);
            this.num = num;
        }
    }

    public boolean isMatch(Card o) {
        return this.num == o.num;
    }

    @Override
    public int compareTo(Card o) {
        if (this.num > o.num) {
            return 1;
        }
        else if (this.num < o.num) {
            return -1;
        }
        if (this.suitVal > o.suitVal) {
            return 1;
        }
        else if (this.suitVal < o.suitVal) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        if (faceCard) {
            return "Card{" + face + " of " + suit + '}';
        }
        else {
            return "Card{" + num + " of " + suit + '}';
        }
    }
}

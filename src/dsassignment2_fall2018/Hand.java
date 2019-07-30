/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsassignment2_fall2018;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents the set of cards in a players' hand The cards are not
 * stored in any particular order Cards can be added and removed from the hand
 *
 * @author clatulip
 */
public class Hand {

    private ArrayList<Card> cards;

    /**
     * Constructor
     */
    public Hand() {
        cards = new ArrayList<Card>();
    }

    /**
     * returns (without removing) a card at a specific index (usually after
     * searching through the whole set of cards using the getCards() method)
     *
     * @param i index of the card to access
     * @return Card at specified index or null
     */
    public Card getCard(int i) {
        try {
            return cards.get(i);
        }
        catch (Exception e) {
            System.out.println("getCard threw exception");
        }
        return null;
    }

    /**
     * Adds a card to the hand
     *
     * @param c Card to add
     */
    public void addCard(Card c) {
        cards.add(c);
    }

    /**
     * returns and removes a card at a specific index (usually after searching
     * through the whole set of cards using the getCards() method)
     *
     * @param i index of the card to access
     * @return Card at specified index or null
     */
    public Card removeCard(int index) {
        try {
            return cards.remove(index);
        }
        catch (Exception e) {
            System.out.println("removeCard threw exception");
        }
        return null;
    }

    /**
     * Returns the whole ArrayList of cards in the hand
     *
     * @return ArrayList<Card> cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Hand{" + "cards=" + cards + '}';
    }

}

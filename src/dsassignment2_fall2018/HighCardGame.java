/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsassignment2_fall2018;

import Exceptions.EmptyCollectionException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.*;
import DataStructures.*;
import ADTs.*;

/**
 *
 * @author clatulip
 */
public class HighCardGame {

    private Deck deck;
    private ArrayList<Hand> hands;
    private int numHands;
    private int numCards;

    /**
     * Constructor
     * @param numHands number of hands to create
     * @param numCards number of cards to deal per hand
     */
    public HighCardGame(int numHands, int numCards) {
        this.numHands = numHands;
        this.numCards = numCards;
        deck = new Deck();
        hands = new ArrayList<>(numHands);
        deal(numHands, numCards);
    }

    // deals appropriate number of cards for each hand
    private void deal(int numHands, int numCards) {
        hands.clear();
        for (int i = 0; i < numHands; i++) {
            hands.add(new Hand());
        }

        for (int j = 0; j < numCards; j++) {
            for (int i = 0; i < numHands; i++) {
                try {
                    hands.get(i).addCard(deck.drawCard());
                }
                catch (EmptyCollectionException ex) {
                    Logger.getLogger(HighCardGame.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Uh-oh! Ran out of cards!");
                }
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numHands; i++) {
            s = s.concat("Hand #" + (i + 1) + ": \n");
            ArrayList<Card> cards = hands.get(i).getCards();
            for (Card c : cards) {
                s = s.concat("\t " + c.toString() + "\n");
            }
        }
        return s;
    }

    public void play() {
        // use the lowest value card as starting comparison
        Card high = new Card(Card.Suit.CLUBS, 2);
        
        int handNum = 0;
        System.out.println("Playing High Card Wins!!!");
        
        // go through each hand
        // sort each hand
        // look at the highest card in each hand and compare it to current high
        for (int i = 0; i < numHands; i++) {
            ArrayList<Card> cards = hands.get(i).getCards();
            Collections.sort(cards);
            if (i == 0) {
                high = Collections.max(cards);
                handNum = 1;
            }
            else {
                if (Collections.max(cards).compareTo(high) == 1) {
                    high = Collections.max(cards);
                    handNum = i + 1;
                }
            }

        }
        System.out.println("High card is: " + high.toString());
        System.out.println("It was in hand: " + handNum);
        System.out.println(this.toString());

    }
}

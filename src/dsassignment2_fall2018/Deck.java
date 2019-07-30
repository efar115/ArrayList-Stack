/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsassignment2_fall2018;

import Exceptions.EmptyCollectionException;
import java.util.ArrayList;
import java.util.Collections;
import DataStructures.*;

/**
 * This class creates a standard set of 52 playing cards (no jokers)
 * Then shuffles the cards and puts them into a stack data structure
 * so that only the top card can be drawn.
 * @author clatulip
 */
public class Deck {

    private ArrayList<Card> cardList;
    private ArrayListStack<Card> deck;

    public Deck() {
        deck = new ArrayListStack<>();
        cardList = new ArrayList<>(52);
        this.initializeDeck();
        this.shuffle();
    }

    private void initializeDeck() {
        for (int i = 2; i <= 14; i++) {
            cardList.add(new Card(Card.Suit.CLUBS, i));
            cardList.add(new Card(Card.Suit.DIAMONDS, i));
            cardList.add(new Card(Card.Suit.HEARTS, i));
            cardList.add(new Card(Card.Suit.SPADES, i));
        }
    }

    /**
     * size of deck
     * @return int size
     */
    public int size() {
        return deck.size();
    }

    /**
     * isEmpty determines whether there are any cards in the deck
     * @return boolean true if deck is empty, false otherwise
     */
    public boolean isEmpty() {
        return deck.size() == 0;
    }

    private void shuffle() {
        Collections.shuffle(cardList);
        for (Card c : cardList) {
            deck.push(c);
        }
    }

    /** 
     * drawCard returns the top card on the deck.
     * @return Card 
     * @throws EmptyCollectionException 
     */
    public Card drawCard() throws EmptyCollectionException {
        if (deck.isEmpty()) {
            throw new EmptyCollectionException("No cards in the deck to draw");
        }
        return deck.pop();
    }

}


package dsassignment2_fall2018;

import Exceptions.EmptyCollectionException;
import java.util.ArrayList;
import DataStructures.*;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Efrem Gebrekidane
 * @version 1.0
 */
public class PairsCardGame {

    private Deck deck;
    private DiscardPile discardPile;
    private ArrayList<Hand> hands;
    private int numHands;
    private final int numCards = 4;
    
    /**
     * Constructor
     */
    public PairsCardGame() {
        //Main deck
        deck = new Deck();
        //Discard discardPile
        discardPile = new DiscardPile(new ArrayStack());
        this.numHands = 4;
    }
    
    /**
     * Constructor
     * @param numHands number of hands to create
     */
    public PairsCardGame(int numHands) {
        //Main deck
        deck = new Deck();
        //Discard discardPile
        discardPile = new DiscardPile(new ArrayStack());
        if (numHands < 10) {
            this.numHands = numHands;
        }
        else {
            this.numHands = 4;
        }
    }

    /**
     * Clear the hands arrayList for each new round. Creates a hand for each
     * player and stores them in the hands ArrayList. Fill each hand with cards
     * from the deck
     *
     * @param numHandss number of players
     * @param numCardss number of cards in each hand
     * @return ArrayList of Hand objects
     */
    public ArrayList<Hand> deal(int numHandss, int numCardss) {
        
        //Initialize a new arrayList and store in hands reference.
    
        hands = new ArrayList<Hand>();
        
        //Initialize correct number of hands and add them to arrayList
        
        for (int i = 0; i < numHandss; i++) {
            hands.add(new Hand());
        }
        //Fill each hand with correct number of cards from the deck
        //Follow proper dealing order 
        for (int j = 0; j < numCardss; j++) {
            for (int i = 0; i < numHandss; i++) {
                try {
                    hands.get(i).addCard(deck.drawCard());
                }
                catch (EmptyCollectionException ex) {
                    Logger.getLogger(HighCardGame.class.
                                getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Uh-oh! Ran out of cards!");
                }
            }
        }

        //Return the ArrayList of hands (used for TA testing)
                
        return hands;
    }

    /**
     * Refill the deck by reinitializing
     */
    private void reshuffle() {
        deck = new Deck();
        discardPile = new DiscardPile(new ArrayStack());
    }

    /**
     * Advance round If the deck is low on cards then reshuffle Check each hand.
     * If a winner is found then break the loop. Print information on the
     * winners
     */
    public void play() {
        hands = deal(numHands, numCards);
        int winningHand = 0;
        boolean winner = false;
        int round = 1;

        System.out.println("Playing the Pairs Game!");
        while (!winner) {
            // if there aren't enough cards in deck for full round, reshuffle 
            if (deck.size() <= numHands) {
                this.reshuffle();
            }
            // do a round of players taking a turn
            if (this.advanceRound()) {
                System.out.println("Round: " + round + " completed!");
                // to watch how the play unfolds, uncomment the next two lines
                //System.out.println("Current cards in each players' hand:");
                //System.out.println(this.toString());
                round++;
            }
            else {
                System.out.println("Player won in Round: " + round + "!");
                for (int j = 0; j < numHands; j++) {
                    // who won?
                    if (this.isWinningHand(this.numMatches(hands.get(j)))) {
                        winningHand = j + 1;
                        winner = true;
                        break; // out of for loop
                    } 
                }
                if (winner) {
                    break; // out of while loop
                }
                else {
                    // shouldn't get here
                    System.out.println("Error. No winner.");
                }
            }
            
        }
        System.out.println("Winning hand for player: " + winningHand + "!");
        System.out.println(this.toString());
    }

    /**
     * Each player draws a card 
     * Check for matches and discards the first non-matching card
     * @return true if a round completes without a player winning or 
     * without running out of cards. False is a player wins.
     *
     */
    private boolean advanceRound() {
        boolean discardDraw = false;
        int[] matches;
        //Each player discards and draws
        for (int i = 0; i < hands.size(); i++) {
            //Matches array shows number of matches for each card
            matches = this.numMatches(hands.get(i));
            try {
                if (!discardPile.isEmpty()) {
                    for (int j = 0; j < hands.get(i).getCards().size(); j++) {
                        if (discardPile.look().
                                isMatch(hands.get(i).getCard(j)) 
                                    && matches[j] != 1) {
                            discardDraw = true;
                            hands.get(i).addCard(discardPile.takeCard());
                            break;
                        }
                    }
                }
                if (!discardDraw) {
                    hands.get(i).addCard(deck.drawCard());
                }
            }
            catch (EmptyCollectionException e) {
                System.out.println("No cards to pick");
                return false;
            }

            for (int j = 0; j < matches.length; j++) {
                //Card can be discarded if there are 0 or 2 matches
                if (matches[j] != 1) {
                    discardPile.addCard(hands.get(i).removeCard(j));
                    break;
                }
            }
            discardDraw = false;
            if (this.isWinningHand(this.numMatches(hands.get(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Each card is checked against the other cards. 
     * A card is considered a match
     * if it has equal value and is not itself If an 
     * index value is 1 then it
     * has a single match
     *
     * @param hand to check for matching cards
     * @return array to show which cards have matches
     */
    private int[] numMatches(Hand hand) {
        int [] matches = new int[hand.getCards().size()];
        for (int i = 0; i < hand.getCards().size(); i++) {
            for (int j = 0; j < hand.getCards().size(); j++) {
                if (hand.getCard(i).isMatch(hand.getCard(j)) && i != j) {
                    matches[i]++;
                }
            }
        }
        return matches;
    }

    /**
     * Takes in array from numMatches and decides if a hand is a winner. Hand is
     * considered a winner if it has four indices with a value of 1
     *
     * @param matches output from numMatches
     * @return if the hand is a winner
     */
    private boolean isWinningHand(int[] matches) {

        int matchCount = 0;
        for (int i = 0; i < matches.length; i++) {
            if (matches[i] == 1) {
                matchCount++;
            }
            else if (matches[i] == 3) {
                //Edge case: has all 4 cards of one type
                //Has two pairs of the same two cards
                matchCount = 4;
            }
        }
        return matchCount == 4;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numHands; i++) {
            s = s.concat("Hand #" + (i + 1) + ": \n");
            ArrayList<Card> cards = hands.get(i).getCards();
            Collections.sort(cards);
            for (Card c : cards) {
                s = s.concat("\t " + c.toString() + "\n");
            }
        }
        return s;
    }

}

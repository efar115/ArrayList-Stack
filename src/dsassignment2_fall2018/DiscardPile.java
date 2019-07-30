
package dsassignment2_fall2018;

import ADTs.StackADT;
import Exceptions.*;

/**
 * This is a class that works with Cards
 * A discard pile works as a standard stack, you can add a card to the top
 * look at the card on the top and take the card on the top
 * This class requires that you pass into the constructors a stack of cards 
 * to operate on. The stack must adhere to StackADT.
 * @author Efrem GEbrekidane
 * @version 1.0
 */
public class DiscardPile {

    private StackADT<Card> pile;
    private int count;
    
    /**
     * Constructor 
     */
    public DiscardPile() {
        pile = new ArrayListStack<Card>();
    }
    

    /**
     * Constructor - pass in an initialized stack data structure
     * @param stack must be an object from a class that implements StackADT
     */
    public DiscardPile(StackADT stack) {
        pile = stack;
        count = 0;
    }

    /**
     * Add a card to the pile
     * @param c Card
     */
    public void addCard(Card c) {
        pile.push(c);
        count++;
    }

    /**
     * Removes and returns the top card from the pile
     * @return Card on top of the pile
     * @throws EmptyCollectionException 
     */
    public Card takeCard() throws EmptyCollectionException {
        Card top;
        if (count == 0) {
            throw new EmptyCollectionException("Stack");
        }
        else {
            top = pile.pop();
            count--;
        }
        return top;
    }

    /**
     * Return (without removing) the card on top of the pile for inspection
     * @return Card on top of the pile
     * @throws EmptyCollectionException 
     */
    public Card look() throws EmptyCollectionException {
        Card top;
        if (isEmpty() ) {
            throw new EmptyCollectionException("Linked List Stack");
        } 
        else {
            top = pile.peek();
        }
        return top;
    }

    /**
     * Find out if the pile has cards
     * @return true if there are no cards, false otherwise
     */
    public boolean isEmpty() {
        
        return count == 0;
       
    }

    /**
     * Find out how many cards are on the discard pile
     * @return int number of cards in the pile
     */
    public int size() {
        return count;
    }
    

}

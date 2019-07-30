
package dsassignment2_fall2018;


import Exceptions.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Efrem Gebrekidane
 * @version 1.0
 */
public class DiscardPileTest {

    /**
     * Test of addCard method, of class DiscardPile.
     */
    @Test
    public void testAddCard() {
        DiscardPile instance = new DiscardPile(); 
        assertEquals(0, instance.size());
        assertTrue(instance.isEmpty()); 
        Card c = new Card(Card.Suit.CLUBS, Card.Face.JACK );
        instance.addCard(c);
        assertEquals(1, instance.size());
        instance.addCard(new Card(Card.Suit.HEARTS, 5));
        instance.addCard(new Card(Card.Suit.SPADES, 10));
        instance.addCard(new Card(Card.Suit.DIAMONDS, 11));
        assertEquals(4, instance.size());
    }

    /**
     * Test of takeCard method, of class DiscardPile.
     */
    @Test
    public void testTakeCard() throws EmptyCollectionException {
        DiscardPile instance = new DiscardPile();
        try {
            instance.takeCard();
            fail("Shouldn't get her");
        } 
        catch (EmptyCollectionException e) {
            System.out.println("Excepted: gets into exception");
        }
        instance.addCard(new Card(Card.Suit.DIAMONDS, 6));
        instance.addCard(new Card(Card.Suit.SPADES, 10));
        Card a = new Card( Card.Suit.SPADES, 20 );
        instance.addCard(a);
        assertEquals(3, instance.size());
        Card s = instance.takeCard();
        assertEquals(a, s);
        assertEquals(2, instance.size());
    }

    /**
     * Test of look method, of class DiscardPile.
     */
    @Test
    public void testLook() throws Exception {
        DiscardPile instance = new DiscardPile(); 
        assertEquals(0, instance.size());
        try {
            instance.look();
            fail("Shouldn't get her");
        } 
        catch (EmptyCollectionException e) {
            System.out.println("Excepted: gets into exception");
        }
        // adding elements to the stack
        instance.addCard(new Card(Card.Suit.DIAMONDS, 6));
        instance.addCard(new Card(Card.Suit.SPADES, 10));
        Card a = new Card(Card.Suit.SPADES, 20);
        instance.addCard(a);
        // after adding 3 elements the stack
        // size should be 3
        assertEquals(3, instance.size());
        // now we peek from the stack
        Card s = instance.look();
        // after peeking the size of the stack should
        // remain the same 
        assertEquals(3, instance.size());
        try {
            instance.look();
            assertFalse(instance.isEmpty());
        } 
        catch (EmptyCollectionException e) {
            System.out.println("Problem: gets into exception");
            fail("Caught exception that shouldn't happen");
        }
        
        assertEquals(a, s);
    }

    /**
     * Test of isEmpty method, of class DiscardPile.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        DiscardPile instance = new DiscardPile();
        // Card Stack should initially be empty
        assertEquals(0, instance.size());
    }

    /**
     * Test of size method, of class DiscardPile.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        DiscardPile instance = new DiscardPile();
        // Card Stack should initially be empty
        assertEquals(0, instance.size());
        // adding Cards to the stack
        instance.addCard(new Card(Card.Suit.DIAMONDS, 6));
        instance.addCard(new Card(Card.Suit.SPADES, 10));
        // after adding 2 cards the stack size should be 2
        assertEquals(2, instance.size());
    }
    
}

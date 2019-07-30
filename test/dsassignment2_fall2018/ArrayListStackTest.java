
package dsassignment2_fall2018;

import Exceptions.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Efrem Gebrekidane
 * @version 1.0
 */
public class ArrayListStackTest {
    

    /**
     * Test of push method, of class ArrayListStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        ArrayListStack<Card> instance = new ArrayListStack<Card>();
        // before we add anything the stack should be empty
        assertTrue(instance.isEmpty());
        // adding card 
        instance.push(new Card(Card.Suit.CLUBS, 2));
        // after adding one Card it should have 1
        assertEquals(1, instance.size());
        // adding more
        instance.push(new Card(Card.Suit.HEARTS, 5));
        instance.push(new Card(Card.Suit.SPADES, 10));
        instance.push(new Card(Card.Suit.DIAMONDS, 11));
        assertEquals(4, instance.size());
    }

    /**
     * Test of pop method, of class ArrayListStack.
     */
    @Test
    public void testPop() throws EmptyCollectionException {
        System.out.println("pop");
        ArrayListStack<Card> instance = new ArrayListStack<>();
        // when we try to pop from an empty stack
        // it should throw an exception
        try {
            instance.pop();
            fail("Shouldn't get her");
        } 
        catch (EmptyCollectionException e) {
            System.out.println("Excepted: gets into exception");
        }
        // adding elements to the stack
        instance.push(new Card(Card.Suit.DIAMONDS, 6));
        instance.push(new Card(Card.Suit.SPADES, 10));
        Card a = new Card(Card.Suit.SPADES, 20);
        instance.push(a);
        assertEquals(3, instance.size());
        // remove an element
        Card s = instance.pop();
        // making sure the element removed
        // is the last element added
        assertEquals(a, s);
        assertEquals(2, instance.size());
        
    }

    /**
     * Test of peek method, of class ArrayListStack.
     */
    @Test
    public void testPeek() throws EmptyCollectionException {
        System.out.println("peek");
        ArrayListStack<Card> instance = new ArrayListStack<>();
        // when we try to peek on empty stack
        // it should throw an exception
        try {
            instance.peek();
            fail("Shouldn't get her");
        } 
        catch (EmptyCollectionException e) {
            System.out.println("Excepted: gets into exception");
        }
        // adding elements to the stack
        instance.push(new Card(Card.Suit.DIAMONDS, 6));
        instance.push(new Card(Card.Suit.SPADES, 10));
        Card a = new Card(Card.Suit.SPADES, 20);
        instance.push(a);
        // after adding 3 elements the stack
        // size should be 3
        assertEquals(3, instance.size());
        // now we peek from the stack
        Card s = instance.peek();
        // after peeking the size of the stack should
        // remain the same 
        assertEquals(3, instance.size());
        try {
            instance.peek();
            assertFalse(instance.isEmpty());
        } 
        catch (EmptyCollectionException e) {
            System.out.println("Problem: gets into exception");
            fail("Caught exception that shouldn't happen");
        }
        
        assertEquals(a, s);
       
    }

    /**
     * Test of isEmpty method, of class ArrayListStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayListStack<Card> instance = new ArrayListStack<>();
        // Card Stack should initially be empty
        assertEquals(0, instance.size());
        
        
    }

    /**
     * Test of size method, of class ArrayListStack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayListStack<Card> instance = new ArrayListStack<>();
        // Card Stack should initially be empty
        assertEquals(0, instance.size());
        // adding Cards to the stack
        instance.push(new Card(Card.Suit.DIAMONDS, 6));
        instance.push(new Card(Card.Suit.SPADES, 10));
        // after adding 2 cards the stack size should be 2
        assertEquals(2, instance.size());
        
       
    }

}

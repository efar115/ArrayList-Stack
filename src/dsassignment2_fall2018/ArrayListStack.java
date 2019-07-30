package dsassignment2_fall2018;

import ADTs.StackADT;
import Exceptions.EmptyCollectionException;
import java.util.ArrayList;

/**
 * @param <T>
 * @author Efrem Gebrekidane
 * @version 1.0
 */
public class ArrayListStack<T> implements StackADT<T> {
    
    private ArrayList<T> stack;
    private int top;

    /**
     * Constructor
    */
    public ArrayListStack() {
        stack = new ArrayList<T>();
        top = 0;
    }

    /**
     * Constructor
     * Adds the specified element to the top of the stack
     * @param element element to be pushed onto the stack
     */
    @Override
    public void push(T element) {
        
        stack.add(element);
        top++;
        
    }

    /**
     * Removes and returns the element that is on top of the stack
     * @return the element removed from the stack
     * @throws EmptyCollectionException 
     */
    @Override
    public T pop() throws EmptyCollectionException {
        /* 
         * Pseudocode:
         * Make sure stack isn't empty, if it is throw exception
         * Create T ref variable and point it at last item added to array
         * set array element at end to null
         * decrement top
         * return T ref variable
         */
        
        int s = stack.size();
        if (s == 0) {
            throw new EmptyCollectionException(
                    "Lottery Bag Empty!");
        }
        
        T tl = stack.remove(s - 1);
        top--;
        return tl;
    
    }

    /**
     * Returns (without removing) the element that is on top of the stack
     * @return the element on top of the stack
     * @throws EmptyCollectionException 
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        return stack.get(top - 1);
    }

    /**
     * Returns true if the stack contains no elements
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        
        return top == 0;
    }

    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack as an int
     */
    @Override
    public int size() {
        return top;
    }

    /**
     * Returns a string representation of elements in the stack
     * @return a string representation of elements in the stack
     */
    @Override
    public String toString() {
        String s = "LotteryBag: \n";
        for (T tl : stack) {
            s = s.concat("\t" + tl.toString() + "\n");
        }
        return s;
    }

   
    
}

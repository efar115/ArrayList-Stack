
package dsassignment2_fall2018;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Efrem Gebrekidane
 * @version 1.0
 */
public class PairsCardGameTest {
    
    /**
     * Test of deal method, of class PairsCardGame.
     */
    @Test
    public void testDeal() {
        PairsCardGame instance = new PairsCardGame();
        instance.deal(2, 5);
        ArrayList<Hand> h = instance.deal(2, 5);
        instance.play(); 
        assertEquals(2, h.size()); 
        int k = h.get(0).getCards().size(); 
        assertEquals(5, k); 
        for(int i= 0; i<k; i++){
            Card l = h.get(0).getCards().get(i);
            assertEquals(h.get(0).getCards().get(i), l);
        }
        int n = h.get(1).getCards().size(); 
        assertEquals(5, n); 
        for(int i= 0; i<n; i++){
            Card l = h.get(1).getCards().get(i);
            assertEquals(h.get(1).getCards().get(i), l);
        }
        
    }

    
}

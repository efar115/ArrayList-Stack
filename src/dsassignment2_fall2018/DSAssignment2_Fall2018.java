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
public class DSAssignment2_Fall2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a game with 5 hands, 4 cards per hand
        HighCardGame hcGame = new HighCardGame(5,4);
        hcGame.play();
        
        //TODO: uncomment these two lines after completing implementation of 
        // DiscardPile.java and the Deal method in PairsCardGame.
        // or, create a pairs game with 5 hands
        PairsCardGame pGame = new PairsCardGame(5);
        pGame.play();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER-LAPTOP
 */
public class HotSnapperBackEndTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("Press RETURN key to start...");
        
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(HotSnapperBackEndTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Csv.readAndStoreCsv();
        
        boolean playAgain = true;
        
        while (playAgain) 
        {
            System.out.println("Play again (Y/N)?");
            String str = scanner.next();
            if (str.equalsIgnoreCase("N"))
            {
                playAgain = false;
                break;
            }
            else
            {
                System.out.println("Hurray! You want to play again!\n");
                PlayGame.nextGame();
                playAgain = true;                
            }
        }
        
        
        System.out.println("I'm free! Application closing.");
        
    }
    
}

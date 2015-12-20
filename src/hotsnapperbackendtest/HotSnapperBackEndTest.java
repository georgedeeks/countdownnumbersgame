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

    public static boolean firstTime = true;
    
    /**
     * 
     * Main application logic for program
     * 
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
        
        boolean again = true;
        
        // whilst user continues to press yes (to another game), loop continues
        while(again)
        {
            // method here
            again = askToPlay(scanner);
        }
        
        // finally...
        System.out.println("I'm free! Application closing.");
        
    }
    
    public static boolean askToPlay(Scanner scanner)
    {
        
        // Prints out initial message if first time
        
        String askToPlay;
        
        if (firstTime)
        {
            firstTime = false;
            askToPlay = "Play game (Y/N)?";
            
            System.out.println(askToPlay);
        }
        
        String str = scanner.next();
        
        if (str.equalsIgnoreCase("Y"))
        {
            
            System.out.println("Hurray! You want to play! Get ready...");
            
            PlayGame.nextGame();
            
            return true;
            
        }
        else
        {
            System.out.println("You don't want to play again!");
            
            return false;                
        }
        
    }
    
}

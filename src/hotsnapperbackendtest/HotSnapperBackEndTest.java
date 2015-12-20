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

    public static boolean firstTime= true;
    
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
        
        boolean again = true;
        
        while(again)
        {
            // method here
            again = askToPlay(scanner);
        }
        
        // finally...
        System.out.println("I'm free from all this! Application closing.");
        
    }
    
    public static boolean askToPlay(Scanner scanner)
    {
        
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
            
            //PlayGame.nextGame();
            // interim stub method call
            //boolean whoCaresAboutThisBoolean = interimStubMethod();
            
            PlayGame.nextGame();
            
            return true;
            
            // return interimStubMethod;
            
        }
        else
        {
            System.out.println("You don't want to play again!");
            
            return false;                
        }
        
    }
    
    public static boolean interimStubMethod()
    {
        System.out.println("Weewees and petunias!");
        
        return true;
    }
    
}

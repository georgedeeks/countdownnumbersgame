/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

import java.util.Scanner;

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
        
        System.out.println("Type in any key (and hit return) to play!");
        
        String stri = scanner.next();
        
        if (stri.isEmpty() == false)
        {
        Csv.readAndStoreCsv();
            
        PlayGame.nextGame();
        
        while (true) 
        {
            System.out.println("Play again (Y/N)?");
            String str = scanner.next();
            if (str.equalsIgnoreCase("N"))
            {
                break;
            }
            else
            {
                System.out.println("Hurray! You want to play again!\n");
                PlayGame.nextGame();
            }
        }
        
        }
        
        System.out.println("I'm free! Application closing.");
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;


/////////////////// I'M A MASSIVE WEEWEE

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
        // TODO code application logic here
        
        ReadFilesInAFolder.printAndStoreFiles();
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) 
        {
            System.out.println("Stop playing game (Y/N)?");
            String str = scanner.next();
            if (str.equalsIgnoreCase("Y"))
            {
                break;
            }
            else
            {
                System.out.println("Hurray! You want to play again!");
                
            }
            
                       
        }
        
        System.out.println("I'm free! Application closing.");
        
        
    }
    
}

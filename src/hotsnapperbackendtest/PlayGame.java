/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * Controller element for playing game, separated from main method
 * 
 * @author ACER-LAPTOP
 */
public class PlayGame {
    
    private static int targetNumber;
    private static int[] numbers = new int[5];
    private static String solutionString;
    
    private static int interval;
    private static Timer timer;
        
    //public PlayGame(){}
    
    public static void nextGame(){
                
        // step 1 - checkCsvJsonSingleton has Qs and/or As
        // step 2 - make decision of whether to:
            // option 2A - generate nothing; csv contains all info
                // SEND TO figure-it-out class
            // option 2B - generate questions and an answer
                // SEND TO generate questions
                // SEND TO generate answers (questions)
        
        //TOSORT//TODO
        // try.catch here?
                
        if (CsvInfoSingleton.isNumbersBoolean() && CsvInfoSingleton.isTargetNumberBoolean())
        {
            // OPTION 2A
            // then we have both calculate numbers AND a target number
            // therefore proceed to calculate their relationship
            
            targetNumber = CsvInfoSingleton.getTargetNumber();
            numbers = CsvInfoSingleton.getNumbers();
            
            solutionString = CalculateRelationship.getAnswerString(targetNumber, numbers);
            
        }
        else
        {
            // OPTION 2B
            // if neither are provided, then we generate both**
            
            //TODO - sort this out with what HOG is doing
            
            // numbers = AnswerGenerator.generateNumbers();
                
            // targetNumber = AnswerGenerator.generateTarget(numbers);
                      
        }
        // **NB possible future development - 
        // if only targetNumber OR only numbers is found in the CSV file, 
        // have application logic to help deal with these 2 cases
        // (so atm we only deal with 2 out of possible 4 cases)
        
        // end of step 2 - we have numbers, target number and solution all in 
        // local declared variables
        
        // step 3 - print out #s, target# & solution in sout
        // (check for try/catch in method itself)
        
        printGame();
        
        // end of game
        
    }
    
    public static void printGame() {
    
        try
        {
        
            System.out.println("Your numbers are: "
                        + "\n " + numbers 
                        + "\n And your target is: " + targetNumber);

            int delay = 0;
            int period = 1000;
            timer = new Timer();
            interval = 31;

            timer.scheduleAtFixedRate
                (new TimerTask() 

                    {
                        public void run() 
                        {
                            if (interval == 1)
                            {
                                timer.cancel(); 
                                System.out.println("\nFinished!");
                            }
                            else
                            {
                                System.out.print(setInterval() + "... ");
                            }
                        }
                    }, 

                    delay, period
                );

        }
        catch (Exception e)
        {
            System.out.println("Problem printing out the game. Please try again.");
        }
        
}

    // also ensures that  anew line after every 10s
private static final int setInterval() {
    
    if ((interval - 1) % 10 == 0 && interval < 30)
    {
        System.out.print("\n");
    }    
           
        return --interval;
}

    
}

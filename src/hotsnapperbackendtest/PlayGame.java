/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

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
                
        // step 1 - checkCsvJsonSingleton has numbers[] && targetNumber
        // step 2 - make decision of whether to:
            // option 2A - generate nothing; csv contains all info
                // SEND TO generate-a-solution method
            // option 2B - CSV has no available info; generate questions and an answer
                // SEND TO generate questions
                // SEND TO generate answers (questions)
        
        // NB - once active CSV info has been used in a game, becomes 
        // unavailable/'inactive'
                
        if (CsvInfoSingleton.isAvailable() == true)
        {
            // OPTION 2A
            // then we have both calculate numbers AND a target number
            // therefore proceed to calculate their relationship
            
            targetNumber = CsvInfoSingleton.getTargetNumber();
            numbers = CsvInfoSingleton.getNumbers();
            
            solutionString = Solver.inputValues(numbers, targetNumber);
            
            // set available to false as we've just used it so 
            //do not use for another game           
            CsvInfoSingleton.getInstance().setAvailable(false);
            
        }
        else
        {
            // OPTION 2B
            // if neither are provided, then we generate numbers, target & solution**
            
            numbers = Question.generate();
            
            String solutionAndTargetString = Answer.generate(numbers);
            
            String[] parts = solutionAndTargetString.split("\\s:\\s\n");
            
            targetNumber = Integer.parseInt(parts[0]);
            
            solutionString = parts[1];
                      
        }
        // **NB possible future development - 
        // if only targetNumber OR only numbers is found in the CSV file, 
        // have application logic to help deal with these 2 cases
        // (so atm we only deal with 2 out of possible 4 cases, i.e. where both
        // or where neither of these 2 csv files)
        
        // end of step 2 - we have 3 elements: 
            // (i) numbers, 
            // (ii) target number  
            // (iii) solution
        // ...all stored as local declared variables
        
        // step 3 - print out #s, target# & solution in sout
        // (check for try/catch in method itself)
        
        printGame();
        
        // end of game; return to main method
        
    }
    
    // method that handles printing out of calculated/discovered variables
    public static void printGame() {
    
        try
        {
            
            String numbersAsString = Csv.numbersToString(numbers);
        
            System.out.println("Your numbers are:"
                        + " " + numbersAsString 
                        + "\nAnd your target is: " + targetNumber);

            int delay = 0;
            int period = 1000;
            timer = new Timer();
            
            // originally, interval int value was 31
            // 31 reflects 30 second countdown timer
            // changed to just 5 seconds for simplicity
            interval = 6;
            
            timer.scheduleAtFixedRate
                (new TimerTask() 

                    {
                        public void run() 
                        {
                            if (interval == 1)
                            {
                                timer.cancel(); 
                                System.out.println("\nFinished! "
                                        + "Solution was:\n" 
                                        + solutionString 
                                        + "Play again (Y/N)?");
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

// this method is used as part of printgame method
// it also ensures that multiples of 10 on the timer
// are printed on a new line (under 30s, the original max timer length)
private static final int setInterval() {
    
    if ((interval - 1) % 10 == 0 && interval < 30)
    {
        System.out.print("\n");
    }    
           
        return --interval;
}

    
}

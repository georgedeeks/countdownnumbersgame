/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ACER-LAPTOP
 */
public class ReadCsv {
    
    // returns 0 if error
    public static int readTargetCsv()
    {
        
        // parameter strategy is either 'numbers' or 'target'
        
        String csvFile = "numbers/" + "target" + ".csv";
      //  System.out.println("csvfile = " + csvFile);
        
        
	BufferedReader br = null;
	
        int targetInt = 0;
        
	try 
        {

            br = new BufferedReader(new FileReader(csvFile));
            
            String targetString = br.readLine();
            
            targetInt = Integer.parseInt(targetString);
               

	} catch (FileNotFoundException e) {
		e.printStackTrace();
                
                
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

        System.out.print("targetint = " + targetInt + " ");
	System.out.print("Done");
        
        return targetInt;
    }
    
    // returns null if error
    public static int[] readNumbersCsv()
    {
        
        // parameter strategy is either 'numbers' or 'target'
        
        String csvFile = "numbers/" + "numbe8rs" + ".csv";
      //  System.out.println("csvfile = " + csvFile);
        
        
	BufferedReader br = null;
	String line = "";

        int[] numbers = new int[5];
        
	try 
        {

            br = new BufferedReader(new FileReader(csvFile));
                
            while ((line = br.readLine()) != null) 
            {

                    // comma separator
                    String[] numbersAsStrings = line.split(",");

                    
                    
                    for (int i = 0; i<5; i++)
                    {
                        numbers[i] = Integer.parseInt(numbersAsStrings[i]);
                        
                        System.out.print(numbers[i] + " ");
                        
                    }
                    
                  
                
            }

	} catch (FileNotFoundException e) {
		e.printStackTrace(); 
                numbers = null;
	} catch (IOException e) {
		e.printStackTrace();
                numbers = null;
                
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	System.out.println("Numbers = " + numbers);
        
        return numbers;
    }
    
    public static void main(String[] args) {
        
        readNumbersCsv();
        
        readTargetCsv();
        
    }

    
}

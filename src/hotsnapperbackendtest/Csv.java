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
public class Csv {
    
    // returns 0 if error
    public static int readTargetCsv()
    {
        
        
        String csvFile = "numbers/" + "target" + ".csv";
        
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
	} finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
		} 
                catch (IOException e) 
                {
                    e.printStackTrace();
		}
            }
	}

        return targetInt;
    
    }
    
    // returns null if error
    public static int[] readNumbersCsv()
    {
        
        String csvFile = "numbers/" + "numbers" + ".csv";
    
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

                }
                    
            }

	} catch (FileNotFoundException e) {
		e.printStackTrace(); 
                numbers = null;
	} catch (IOException e) {
		e.printStackTrace();
                numbers = null;
	} finally {

            if (br != null) 
            {
		try {
                    br.close();
		} catch (IOException e) {
                    e.printStackTrace();
		}
            }
	}
        
        return numbers;
        
    }
    
    // converts int[] into a suitable toString method
    public static String numbersToString(int[] numbers)
    {
        String numbersResult = ""; //i.e. if unchanged
        
        for (int i = 0; i < numbers.length; i++)
        {
            numbersResult += Integer.toString(numbers[i]) + " ";
        }    
        
        return numbersResult;
    }
    
    // test harness
    public static void main(String[] args) {
        
        readNumbersCsv();
        
        readTargetCsv();
        
    }
    
    /**
    * 
    * Reads CSV files in local directory - if values successfully read,
    * stores these in another static singleton class
    * 
    * @author ACER-LAPTOP
    */
    public static void readAndStoreCsv()
    {
        // read
        
        int[] numbers = readNumbersCsv();
        
        int target = readTargetCsv();
        
        // store
        
        if (numbers != null && target != 0)
        {
            //then successful extract of values from csv file
            
            // store numbers and target in singleton
            
            CsvInfoSingleton.getInstance().setTargetNumber(target);
            
            CsvInfoSingleton.getInstance().setNumbers(numbers);
            
            CsvInfoSingleton.getInstance().setAvailable(true);
            
        }
        else
        {
            // set available boolean to false as there was an error
            
           CsvInfoSingleton.getInstance().setAvailable(false);
        
        }
                
    }

    
}

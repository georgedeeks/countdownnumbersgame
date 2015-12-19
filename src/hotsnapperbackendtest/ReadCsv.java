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
    
    public void readCsv()
    {
        String csvFile = "/numbers/numbers.csv";
	BufferedReader br = null;
	String line = "";

	try 
        {

            br = new BufferedReader(new FileReader(csvFile));
                
            while ((line = br.readLine()) != null) 
            {

                    // comma separator
                    String[] numbersAsStrings = line.split(",");

                    int[] numbers = new int[5];
                    
                    for (int i = 0; i<5; i++)
                    {
                        numbers[i] = Integer.parseInt(numbersAsStrings[i]);
                        
                        System.out.println(numbers[i] + " ");
                        
                    }

            }

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

	System.out.println("Done");
  }

    
}

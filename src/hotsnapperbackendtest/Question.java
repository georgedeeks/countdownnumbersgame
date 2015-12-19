/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Helen
 */
public class Question {
    private static Random random = new Random();
    
   public static int[] generate()
   {
      //Initialize variables
      int[] values = new int[5];
      ArrayList<Integer> range = new ArrayList();
      int selected;
      int count = 0;
      //Step 1. Populate range ArrayList with values 1 - 12
      for(int i = 1; i <= 12; i++)
      {
         range.add(i);
      }
      //Step 2. Populate values int[] with 5 numbers randomly selected between 
      //        1 - 12 (taken from ArrayList)
      while(count < 5)
      {
         selected = (random.nextInt(range.size()) + 1) - 1;
         values[count] = range.get(selected);
         range.remove(selected);
         count++;
      }
      return values;
   }

}
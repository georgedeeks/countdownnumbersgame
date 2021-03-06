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
 * @author George
 */
public class Answer {
    
   private static Random random = new Random();
    
   /**
    * Takes 5 numbers and generates a solution, 
    * including the target number, all in 1 String
    * 
     * @param nos
     * @return String
    */
   public static String generate(int[] nos)
   {
       //Initialize variables needed
       ArrayList<Integer> numbers = new ArrayList(); 
       int answer;
       int selected;
       int operator;
       int temp = 0;
       int n;
       String str;
       String output = "";
       
      //Step 1. Populate the numbers ArrayList with the csv
      for(int i = 0; i < nos.length; i++)
      {
         numbers.add(nos[i]);
      }
      
      //Step 3. Select a random number from the csv and then remove it
      selected = (random.nextInt(numbers.size()) + 1) - 1;
      answer = numbers.get(selected);
      numbers.remove(selected);
      
      //Step 4. Generate each step in calculating the answer 
      while(!numbers.isEmpty())
      {
         selected = (random.nextInt(numbers.size()) + 1) - 1;
         
         n = numbers.get(selected);
         
         // Now randomly pick which operation you want to use
         //(Addition and multiplication have 2x greater chance)
         
         operator = random.nextInt(6) + 1;
         
         switch(operator)
         {
            //Addition
            //Note: Need to check value is below 1000 before comitting it!
            case 1: 
            case 2: str = answer + " + " + n;
                    temp = answer;
                    temp = temp + n;
                    if(temp < 1000)
                    {
                       answer = temp;
                       output += str + " = " + answer + "\n";
                       numbers.remove(selected);
                       break;
                    }
                    break;
            //Subtraction
            //note: Need to check value is above 0 before commiting it!
            case 3: str = answer + " - " + n;
                    temp = answer - n;
                    if(temp > 0)
                    {
                       answer = temp;
                       output += str + " = " + answer + "\n";
                       numbers.remove(selected);
                       break;
                    }
                    break;
                   
            //Multiplication
            //Note: Need to check value is below 1000 before commiting it!
            case 4:
            case 5: str = answer + " * " + n;
                    temp = answer;
                    temp = temp * n;
                    if(temp < 1000)
                    {
                       answer = temp;
                       output += str + " = " + answer + "\n";
                       numbers.remove(selected);
                       break;
                    }
                    break;
         
            //Division
            //note: Need to check value is divisible before commiting it!
            case 6: str = answer + " / " + n;
                    temp = answer;
                    double decAns = (double) temp / n;
                    decAns = decAns*10;
                    if(decAns % 10 == 0)
                    {
                       answer = temp / n;
                       output += str + " = " + answer + "\n";
                       numbers.remove(selected);
                       break;
                    }
                    break;
         }
      }
      return answer + " : " + "\n" + output;
   }
   
   // test this class works in main harness
   public static void main(String[] args)
   {
      int[] nos = new int[5];
      
      System.out.println(Answer.generate(nos));
      System.out.println();
      int count = (random.nextInt(2) + 1) + 3;
      
      
      nos = Question.generate();
      for(int i = 0; i < nos.length; i++)
      {
          System.out.println(nos[i]);
      }
       
      System.out.println("");
      
      System.out.println(Answer.generate(Question.generate()));
      
   }
    
    
}

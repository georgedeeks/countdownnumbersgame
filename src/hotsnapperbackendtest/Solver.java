/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author George (plus online help)
 * This class was implemented with help from:
 * http://stackoverflow.com/questions/15293232/how-to-design-an-algorithm-to-calculate-countdown-style-maths-number-puzzle
 */
public class Solver {
    public static String inputValues(int[] numbers, int target)
    {        
        List<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> noList = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        int temp;
        String oTemp;
        int step = 0;
        
        //e.g. numbers: 3, 4, 8, 7, 12
        for (int i = 0; i < numbers.length; i++)
        {
            list.add(numbers[i]);
        }
        
        Result result = null;
        
        //e.g. The target number is eg 532
        for (Integer integer : list) 
        {
            List<Integer> runList = new ArrayList<>(list);
            runList.remove(integer);
            String ans = Answer.generate(numbers).split(" : ")[0];
            result = getOperations(runList, integer, target);
            
            //Modified code to make formatting of result more consistent
            if (result.success) 
            {
                //'split' out each individual step in the answer
                String[] parts = result.output.split("@");
                
                //Create two lists - one for each number used in the answer, and
                //one for each operation used!
                for(int i = 0; i < parts.length; i++)
                {
                    temp = Integer.parseInt(parts[i].split(" ")[2]);
                    oTemp = parts[i].split(" ")[1];
                    noList.add(temp);
                    operators.add(oTemp);
                }
                
                temp = integer;
                result.output = "";
                
                //Go through each step (represented by step) and create a String
                //representation of the sum (e.g. 12 * 7 = 14, 8 - 3 = 5, etc.)
                
                while(step < noList.size())
                {                
                    switch(operators.get(step))
                    {
                       case("+"): result.output += temp + " + " + noList.get(step);
                                  temp = temp + noList.get(step);  
                                  result.output += " = " + temp + "\n";
                                  step++;
                                  break;
                       case("-"): result.output += temp + " - " + noList.get(step); 
                                  temp = temp - noList.get(step);
                                  result.output += " = " + temp + "\n";
                                  step++;
                                  break;
                       case("*"): result.output += temp + " * " + noList.get(step);  
                                  temp = temp * noList.get(step);
                                  result.output += " = " + temp + "\n";
                                  step++;
                                  break;
                       case("/"): result.output += temp + " * " + noList.get(step);  
                                  temp = temp / noList.get(step);
                                  result.output += " = " + temp + "\n";
                                  step++;
                                  break;
                    }
                    
                }
            }
        }
        
        return result.output;
    }

    public static class Result
    {
        public String output;
        public boolean success;
    }

    public static Result getOperations(List<Integer> numbers, 
            int midNumber, int target)
    {
        Result midResult = new Result();
        if (midNumber == target) {
            midResult.success = true;
            midResult.output = "";
            return midResult;
        }
        for (Integer number : numbers) {
            List<Integer> newList = new ArrayList<Integer>(numbers);
            newList.remove(number);
            if (newList.isEmpty()) {
                if (midNumber - number == target) {
                    midResult.success = true;
                    midResult.output = " - " + number + " =@";
                    return midResult;
                }
                if (midNumber + number == target) {
                    midResult.success = true;
                    midResult.output = " + " + number + " =@";
                    return midResult;
                }
                if (midNumber * number == target) {
                    midResult.success = true;
                    midResult.output = " * " + number + " =@";
                    return midResult;
                }
                if (midNumber / number == target) {
                    midResult.success = true;
                    midResult.output = " / " + number + " =@";
                    return midResult;
                }
                midResult.success = false;
                midResult.output = "f" + number;
                return midResult;
            } else {
                midResult = getOperations(newList, midNumber - number, target);
                if (midResult.success) {
                    midResult.output = " - " + number  + " =@" + midResult.output;
            //        System.out.println();
                    return midResult;
                }
                midResult = getOperations(newList, midNumber + number, target);
                if (midResult.success) {
                    midResult.output = " + " + number  + " =@" + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber * number, target);
                if (midResult.success) {
                    midResult.output = " * " + number + " =@" + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber / number, target);
                if (midResult.success) {
                    midResult.output = " / " + number + " =@" + midResult.output;
                    return midResult;
                }
            }

        }
        return midResult;
    }
}
    


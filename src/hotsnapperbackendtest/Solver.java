/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Helen
 */
public class Solver {

    public static void main(String[] args)
    {
        int[] nos = Question.generate();
        List<Integer> list = Arrays.asList(3, 4, 8, 7, 12);
        //following numbers: 3, 4, 8, 7, 12

        //The target number is 532
        for (Integer integer : list) {
            List<Integer> runList = new ArrayList<>(list);
            runList.remove(integer);
            String ans = Answer.generate(nos).split(" : ")[0];
            System.out.println(ans);
            Result result = getOperations(runList, integer, 532);
            if (result.success) {
                System.out.println(integer + result.output);
                return;
            }
        }
    }

    public static class Result
    {

        public String output;
        public boolean success;
    }

    public static Result getOperations(List<Integer> numbers, int midNumber, int target)
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
                    midResult.output = "-" + number;
                    return midResult;
                }
                if (midNumber + number == target) {
                    midResult.success = true;
                    midResult.output = "+" + number;
                    return midResult;
                }
                if (midNumber * number == target) {
                    midResult.success = true;
                    midResult.output = "*" + number;
                    return midResult;
                }
                if (midNumber / number == target) {
                    midResult.success = true;
                    midResult.output = "/" + number;
                    return midResult;
                }
                midResult.success = false;
                midResult.output = "f" + number;
                return midResult;
            } else {
                midResult = getOperations(newList, midNumber - number, target);
                if (midResult.success) {
                    midResult.output = "-" + number + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber + number, target);
                if (midResult.success) {
                    midResult.output = "+" + number + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber * number, target);
                if (midResult.success) {
                    midResult.output = "*" + number + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber / number, target);
                if (midResult.success) {
                    midResult.output = "/" + number + midResult.output;
                    return midResult;
                }
            }

        }
        return midResult;
    }
}
    

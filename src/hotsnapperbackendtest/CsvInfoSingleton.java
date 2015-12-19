/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

/**
 *
 * @author ACER-LAPTOP
 */
public class CsvInfoSingleton {
        
    private static int[] numbers = new int[5];
    private static int targetNumber;    
    private static boolean numbersBoolean;
    private static boolean targetNumberBoolean;
    
    private static boolean available;

    public static boolean isAvailable() {
        return available;
    }

    public static void setAvailable(boolean available) {
        CsvInfoSingleton.available = available;
    }
    
    public static int[] getNumbers() {
        return numbers;
    }

    public static void setNumbers(int[] numbers) {
        CsvInfoSingleton.numbers = numbers;
    }

    public static int getTargetNumber() {
        return targetNumber;
    }

    public static void setTargetNumber(int targetNumber) {
        CsvInfoSingleton.targetNumber = targetNumber;
    }

    public static boolean isNumbersBoolean() {
        return numbersBoolean;
    }

    public static void setNumbersBoolean(boolean numbersBoolean) {
        CsvInfoSingleton.numbersBoolean = numbersBoolean;
    }

    public static boolean isTargetNumberBoolean() {
        return targetNumberBoolean;
    }

    public static void setTargetNumberBoolean(boolean targetNumberBoolean) {
        CsvInfoSingleton.targetNumberBoolean = targetNumberBoolean;
    }
    
    
    
}

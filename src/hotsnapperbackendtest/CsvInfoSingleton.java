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
    
    private static boolean available = false;


     //create an object of SingleObject
   private static CsvInfoSingleton instance = new CsvInfoSingleton();

   //make the constructor private so that this class cannot be
   //instantiated
   private CsvInfoSingleton(){}

   //Get the only object available
   public static CsvInfoSingleton getInstance(){
      return instance;
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

    public static boolean isAvailable() {
        return available;
    }

    public static void setAvailable(boolean available) {
        CsvInfoSingleton.available = available;
    }
    
}

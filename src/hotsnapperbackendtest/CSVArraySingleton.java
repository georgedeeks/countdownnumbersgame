/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotsnapperbackendtest;

import java.util.ArrayList;

/**
 *
 * @author ACER-LAPTOP
 */
public class CSVArraySingleton {
    
    private static ArrayList<ArrayList> instance;
    
    public static ArrayList getInstance(){
    
        if (instance == null)
        {
            instance = new ArrayList();
        }
            
        return instance;
        
    }
    
    
   
    
}

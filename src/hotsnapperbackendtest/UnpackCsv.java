package hotsnapperbackendtest;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER-LAPTOP
 */
public class UnpackCsv {
    
    private static final String folderFilePath = "numbers/";
    private static final String testNumbersFileName = "numbers_";
    
    private static ArrayList<String> filePathArray;
    private static ArrayList<String> resultsArrayToStore;
    
    public UnpackCsv()
    {}
    
    public static void readAndStoreFiles(){
        try 
        {
            
            
            
            Files.walk(Paths.get(folderFilePath)).forEach((Path filePath) -> 
                {
                    if (Files.isRegularFile(filePath)) 
                    {
                        
                        String filePathString = filePath.getFileName().toString();
                        
                        System.out.println(filePathString);
                        
                        filePathArray = new ArrayList<String>();
                        
                    }
                }                
            );    
            
            //checkAndStoreIfTestNumbers();
        
            //TODO
            // set available Boolean for singleton
            
        } 
        catch (Exception ex) 
        {
            
            Logger.getLogger(UnpackCsv.class.getName()).log(Level.SEVERE, null, ex);
        
            //TODO
            // set available Boolean for singleton
                        
        }
    }
    
    // TODO check and store in a JSONSingleton
    public static void checkAndStoreIfTestNumbers()
    {
        
        // see which file names correspond to test numbers file name
        
        for (int i = 0; i < filePathArray.size(); i++)
        {
            if (filePathArray.get(i).contains(testNumbersFileName))
            {
                resultsArrayToStore.add(filePathArray.get(i));
            }
        }
        
        // now store results array
        
        //TODO
               
        
    }
    
}

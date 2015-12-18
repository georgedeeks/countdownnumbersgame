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
public class ReadFilesInAFolder {
    
    private static final String folderFilePath = "numbers/";
    private static final String testNumbersFileName = "numbers_";
    
    private static ArrayList<String> filePathArray;
    private static ArrayList<String> resultsArrayToStore;
    
    public ReadFilesInAFolder()
    {}
    
    public static void printAndStoreFiles(){
        try {
            
            Files.walk(Paths.get(folderFilePath)).forEach((Path filePath) -> 
                {
                    if (Files.isRegularFile(filePath)) 
                    {
                        
                        String filePathString = filePath.getFileName().toString();
                        
                        System.out.println(filePathString);
                        
                        filePathArray = new ArrayList<String>();
                        
                     //   filePathArray.add(filePathString);
                        
                        //System.out.println(filePathString);
                            // e.g. Hello1.txt                    
                        
                    }
                }                
            );    
            
            //checkAndStoreIfTestNumbers();
        
        } catch (IOException ex) {
            
            Logger.getLogger(ReadFilesInAFolder.class.getName()).log(Level.SEVERE, null, ex);
        
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

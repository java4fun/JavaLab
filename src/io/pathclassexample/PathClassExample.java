package io.pathclassexample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PathClassExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Path path = Paths.get("Hello World.txt");
        try {
            Files.deleteIfExists(path);
        } catch (IOException ex) {
           
        }
        
        Path path2 = Paths.get("C:\\Users\\Bethan Palmer\\Desktop\\myFiles\\example.txt");
        System.out.println(path2.getParent());
        System.out.println(path2.getRoot());
        System.out.println(path2.getFileName());
      
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher150109n;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Ashen De Silva
 */
public class FileIO {
    
    public static String readFile(String path){
        
        String fileText = "";
        String line;
        
        try{
            FileReader fileReader =new FileReader(path);
                
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                fileText+=line; 
            }   
            bufferedReader.close();
            fileReader.close();
        } catch(FileNotFoundException fx){
            System.out.println("File not found");
        } catch (IOException ex){
            System.out.print("Unable to read file");
        }
        finally{
            return fileText;
        }
    }
    
    public static void writeFile( String text, String path){
        try{
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.close();
            fileWriter.close();
        } catch(IOException ex){
            System.out.println("Error writing file");
        }
    }
}

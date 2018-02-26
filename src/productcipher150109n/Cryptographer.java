/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher150109n;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Arrays;
import java.lang.Object;

/**
 *
 * @author Ashen De Silva
 */
public class Cryptographer {
    
    private final int rounds, blockSize;
    private String key;

    public String getKey() {
        return key;
    }
    String alphabet="0123456789";
    
    public Cryptographer(){        
        this.blockSize= 8;
        key = generateKey();
        this.rounds= (Integer.parseInt(alphabet))%10;
        System.out.println(String.format("Product cipher initiliazed [Rounds: '%s', Key: '%s']", String.valueOf(rounds), key));
    }
    
    private String generateKey(){
        SecureRandom rand = new SecureRandom();
        StringBuilder keyBuilder = new StringBuilder(blockSize);
        
        for(int i=0; i<blockSize;i++){
            keyBuilder.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        return keyBuilder.toString();        
    }
    
    public String encrypt(String message,String key, boolean encrypt){
        /*for(int round=0;round<=rounds;round++){
            for(int i=0; i<=block.length();i++){
                
            }    
        }  */        
        String[] blocks = makeBlocks(message);
        StringBuilder encrypted= new StringBuilder(message.length());
        for (String block: blocks){
            encrypted.append(substitute(block, key, encrypt));
        }
        return encrypted.toString();
    }
    
    
    
    private String substitute(String block, String key, boolean encrypt){
        StringBuilder substituted = new StringBuilder(blockSize);
        char temp;
        for(int i=0; i<block.length();i++){
            if(encrypt){
                temp = (char)((int)block.charAt(i) - (int)(key.charAt(i)));
            }else{
                temp = (char)((int)block.charAt(i) + (int)(key.charAt(i)));
            }            
            substituted.append(temp);
        } 
        return substituted.toString();
    }
    
    /*private String transpose(String block, int[] keyChars, boolean encrypt){
        StringBuilder transposed = new StringBuilder(blockSize);
        for(int i=0; i<block.length();i++){
            if(encrypt){
                transposed.append(block.charAt(keyChars[i]))
            }
        }
    }*/
    
    private String[] makeBlocks(String message){
        String[] tokens = message.split("(?<=\\G.{"+Integer.toString(blockSize)+"})");
        System.out.println(Arrays.toString(tokens));
        return tokens;
    }
    

    
    
}

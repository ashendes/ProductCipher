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
    
    private final int blockSize;
    private String key;

    public String getKey() {
        return key;
    }
    String alphabet="0123456789";
    
    public Cryptographer(){        
        this.blockSize= 8;
        key = generateKey();
        System.out.println(String.format("Product cipher initiliazed [ Key: '%s']", key));
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
        String[] blocks = makeBlocks(message);
        System.out.println(Arrays.toString(blocks));
        String tempText;
        StringBuilder encrypted= new StringBuilder(message.length());
        if(encrypt){
            for (String block: blocks){
                tempText = substitute(block, key, encrypt);                
                //tempText = transpose(block, key, encrypt);
                //tempText = xorOp(block);
                encrypted.append(tempText);
            }
        } else{
            for (String block: blocks){
                //tempText = xorOp(block);
                //System.out.println(tempText);
                //tempText = transpose(block, key, encrypt);
                tempText = substitute(block, key, encrypt);               
                encrypted.append(tempText);
            }
        }
        System.out.println(encrypted.toString());
        return encrypted.toString();
    }
    
    private String transpose(String message, String key, boolean encrypt){
        int offset = Integer.parseInt(key)%10;
        byte[] ba = message.getBytes();
        byte[] newBA = new byte[ba.length];
        for(int i=0; i<ba.length;i++){
            if(encrypt){
                if((i+offset)<newBA.length)
                    newBA[i+offset] = ba[i];
                else
                    newBA[(i+offset)%newBA.length]=ba[i];
            } else{
                if((i-offset)>=0)
                    newBA[i-offset] = ba[i];
                else
                    newBA[Math.abs((i-offset)%newBA.length)]=ba[i];
            }                
        }
        return newBA.toString();
    }
    
    private String substitute(String block, String key, boolean encrypt){
        StringBuilder substituted = new StringBuilder(blockSize);
        char temp;
        for(int i=0; i<block.length();i++){
            try{
                if(encrypt){
                    temp = (char)((int)block.charAt(i) - (int)(key.charAt(i)));
                }else{
                    temp = (char)((int)block.charAt(i) + (int)(key.charAt(i)));
                }
                substituted.append(temp);  
            }catch (StringIndexOutOfBoundsException ex){
                System.err.println("String index Error at "+i + " :"+ block);
            }                            
        } 
        
        return substituted.toString();
    }
    
    private String xorOp(String message){
        byte[] ba = message.getBytes();
        byte[] kba = key.getBytes();
        //System.out.println(ba);
        //System.out.println(kba);
        byte[] out = new byte[ba.length];
        for(int i=0; i<ba.length;i++){
            
            try{
                out[i] = (byte) (ba[i] ^ kba[i%kba.length]);
            } catch (ArrayIndexOutOfBoundsException ex){
                System.err.println("Error at "+i);
            }
            
        }
        return out.toString();
    }
    
    private String[] makeBlocks(String message){
        String[] tokens = message.split("(?<=\\G.{"+Integer.toString(blockSize)+"})");
        //System.out.println(Arrays.toString(tokens));
        return tokens;
    }
    

    
    
}

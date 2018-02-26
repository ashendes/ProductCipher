/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher150109n;

/**
 *
 * @author Ashen De Silva
 */
public class ProductCipher150109N {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Cryptographer machine = new Cryptographer();
        String encrypted=machine.encrypt("My name is ashen. What's up yo? How you doing?", true);
        System.out.println(encrypted);
        System.out.println(machine.encrypt(encrypted, false));*/
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncryptUI().setVisible(true);
            }
        });
    }
    
}

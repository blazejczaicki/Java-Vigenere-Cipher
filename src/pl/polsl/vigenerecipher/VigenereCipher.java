/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.vigenerecipher;

import pl.polsl.vigenerecontroller.Controller;

/**
 * Main Class
 *
 * @version 2.0
 * @author Błażej Czaicki
 */
public class VigenereCipher {

    /**
     * Enum type using at choosing operation encrypting or decrypting
     */
    public enum Operation {
        ENCRYPT('S', 's'),
        DECRYPT('D', 'd');

        private final char cUpper;
        private final char cLower;

        Operation(char cUpper, char cLower) {
            this.cUpper = cUpper;
            this.cLower = cLower;
        }

        /**
         *
         * @param c sign with character from user
         * @return true if sign is correct with defined values
         */
        public boolean checkSign(char c) {
            return c == cUpper || c == cLower;
        }
    }

    /**
     * @param args first arg:operation(s-encrypt/d-decrypt/other), second
     * arg:key(lowercasse), third arg:filename(to read), fourth arg: filename(to
     * write)
     */
    public static void main(String[] args) {
        /**
         * initialization Controller's object
         */
        Controller controller = new Controller();
        /**
         * value for choosing properly operation
         */
        char c = controller.chooseOperation(args);
        if (Operation.ENCRYPT.checkSign(c)) {
            controller.encrypt(args);
        } else if (Operation.DECRYPT.checkSign(c)) {
            controller.decrypt(args);
        }
    }

}

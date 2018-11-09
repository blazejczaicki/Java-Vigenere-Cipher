/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.vigeneremodel;

import java.util.ArrayList;
import pl.polsl.wrongkeyexception.WrongKeyException;

/**
 * Class model type for encryptin and decrypting text.
 *
 * @version 2.0
 * @author Błażej Czaicki
 */
public class CipherMachine {

    /**
     * Vigenere array which has special system of letters.
     */
    private final ArrayList<ArrayList<Character>> vigenereTable; //collection

    /**
     * Method checking correction of key
     *
     * @param key
     * @return compatibility with pattern
     */
    private boolean isLowerCase(String key) {
        return key.matches("[a-z]+");
    }

    /**
     * Non-parameter constructor CipherMachine- creating Vigenere array
     */
    public CipherMachine() {
        vigenereTable = new ArrayList<>();
        int tmp;
        for (int i = 0; i < 26; i++) {
            vigenereTable.add(i, new ArrayList<>());
            tmp = (97 + i);
            for (int j = 0; j < 26; j++) {
                if (tmp > 122) {
                    tmp = 97;
                }
                vigenereTable.get(i).add(j, (char) (tmp));
                tmp++;
            }
        }
    }

    /**
     * Encrypting text using key
     *
     * @param text text ot encrypt
     * @param key key to encrypt
     * @return text
     * @throws pl.polsl.wrongkeyexception.WrongKeyException
     */
    public String encrypt(String text, String key) throws WrongKeyException, NullPointerException {
        if (text == null || key == null) {
            throw new NullPointerException("Text or key is null");
        }
        if (!isLowerCase(key)) {
            throw new WrongKeyException("Zla skladnia klucza!");
        }
        /**
         * keyCounter- using to cross the key string
         */
        int keyCounter = 0;
        /**
         * cNormal- stores current char sign form text
         */
        int cNormal;
        /**
         * cKey- stores current char(stores as int) sign from key
         */
        int cKey;
        /**
         * correction- takes into account uppercases
         */
        int correction;
        /**
         * strB- stores encrypting text
         */
        StringBuilder strB = new StringBuilder();
        //for(int i=0;i<text.length();i++)
        for (char ch : text.toCharArray()) {           //foreach
            cNormal = ch;//text.charAt(i)
            if (Character.isAlphabetic(cNormal)) {
                cKey = key.charAt(keyCounter) - 97;
                if (Character.isUpperCase(cNormal)) {
                    correction = 65;
                    int c = vigenereTable.get(cNormal - correction).get(cKey) - 32;
                    //int c=vigenereArray[cNormal-correction][cKey]-32;
                    strB.append((char) c);
                } else {
                    correction = 97;
                    strB.append(vigenereTable.get(cNormal - correction).get(cKey));
                    //strB.append(vigenereArray[cNormal-correction][cKey]);
                }

                if (keyCounter == key.length() - 1) {
                    keyCounter = 0;
                } else {
                    keyCounter++;
                }
            } else {
                strB.append((char) cNormal);
            }
        }
        text = strB.toString();
        return text;
    }

    /**
     * Decrypting text using key
     *
     * @param text to decrypting
     * @param key to decrypting
     * @return text
     * @throws pl.polsl.wrongkeyexception.WrongKeyException
     */
    public String decrypt(String text, String key) throws WrongKeyException, NullPointerException {
        if (text == null || key == null) {
            throw new NullPointerException("Text or key is null");
        }
        if (!isLowerCase(key)) {
            throw new WrongKeyException("Zla skladnia klucza!");
        }
        /**
         * keyCounter- using to cross the key string
         */
        int keyCounter = 0;
        /**
         * cNormal- stores current char sign form text
         */
        char cNormal;
        /**
         * cKey- stores current char sign from key
         */
        int cKey;
        /**
         * strB- stores decrypting text
         */
        StringBuilder strB = new StringBuilder();
        //for(int i=0;i<text.length();i++)
        for (char ch : text.toCharArray()) //foreach
        {
            cNormal = ch;//text.charAt(i)
            if (Character.isAlphabetic(cNormal)) {
                cKey = key.charAt(keyCounter) - 97;
                if (Character.isUpperCase(cNormal)) {
                    cNormal += 32;
                    for (int a = 0; a < 26; a++) {
                        if (vigenereTable.get(a).get(cKey) == cNormal) {
                            strB.append((char) (vigenereTable.get(a).get(0) - 32));
                        }
                    }
                    // if(vigenereArray[a][cKey]==cNormal)
                    //  strB.append((char)(vigenereArray[a][0]-32));
                } else {
                    for (int a = 0; a < 26; a++) {
                        if (vigenereTable.get(a).get(cKey) == cNormal) {
                            strB.append((char) (vigenereTable.get(a).get(0)));
                        }
                    }
                    //   if(vigenereArray[a][cKey]==cNormal)
                    //    strB.append(vigenereArray[a][0]);
                }

                if (keyCounter == key.length() - 1) {
                    keyCounter = 0;
                } else {
                    keyCounter++;
                }
            } else {
                strB.append(cNormal);
            }
        }
        text = strB.toString();
        return text;
    }
}

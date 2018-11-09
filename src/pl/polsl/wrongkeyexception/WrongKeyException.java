/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.wrongkeyexception;

/**
 * Exception class for readKey method from UserInterface thrown when key has wrong syntax.
 * 
 * @version 1.0
 * @author Błażej Czaicki
 */

public class WrongKeyException extends Exception {              
     /**
     * Non-parameter constructor 
     */
    public WrongKeyException(){}
     /**
     * Constructor
     * @param message display message
     */
    public WrongKeyException(String message){
        super(message);
    }
}

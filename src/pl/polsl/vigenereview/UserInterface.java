/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.vigenereview;

/**
 * Interface UserInterface allow creating different interfaces like text or
 * graphics
 *
 * @version 1.0
 * @author Błażej Czaicki
 */
public interface UserInterface {

    /**
     * Read key from args parameter or user
     *
     * @param args
     * @param correctArgs parameter checking correction args
     * @return key
     */
    public String readKey(String[] args, boolean correctArgs);

    /**
     * Read filename from args parameter or user
     *
     * @param args
     * @param correctArgs parameter checking correction args
     * @param numberOfName number filename (to read or to write) from args
     * @param nameOperation using to displaying information related writing or
     * reading to file
     * @return filename
     */
    public String readFilename(String[] args, boolean correctArgs, int numberOfName, String nameOperation);

    /**
     * Display diffrent text, for example from exceptions
     *
     * @param text to display
     */
    public void printText(String text);

    /**
     * Reading from user sign which indicate on encrypt [s] or decrypt [d],
     * other signs meaning leave from program
     *
     * @param args
     * @return sign of operation
     */
    public char chooseOperation(String[] args);
}

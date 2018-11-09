/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.vigenerecontroller;

import pl.polsl.vigeneremodel.CipherMachine;
import pl.polsl.vigeneremodel.FileSupport;
import pl.polsl.vigenereview.ConsoleInterface;
import pl.polsl.vigenereview.UserInterface;
import java.io.FileNotFoundException;
import java.io.IOException;
import pl.polsl.wrongkeyexception.WrongKeyException;

/**
 * Class which manages View(UserInterface) and Model(FileSupport and
 * CipherMachine)
 *
 * @version 2.0
 * @author Błażej Czaicki
 */
public class Controller {

    /**
     * UserInterface object
     */
    private final UserInterface ui;
    /**
     * FileSupport object (reading and writing text to file)
     */
    private final FileSupport fileSupport;
    /**
     * CipherMachine object (encrypt and decrypt)
     */
    private final CipherMachine cipherMachine;

    /**
     * Non-parameter constructor, initialization objects
     */
    public Controller() {
        ui = new ConsoleInterface();
        cipherMachine = new CipherMachine();
        fileSupport = new FileSupport();
    }

    /**
     * Method reading data for filename, key, text.
     *
     * @param args
     * @param dataArray for filename, key and text
     * @return correction of args
     */
    private boolean readData(String[] args, String[] dataArray) {
        /**
         * boolean value to checking correction of data in loop
         */
        boolean correct = false;
        /**
         * boolean value to checking correction of data from args
         */
        boolean correctArgs = true;
        while (!correct) {
            try {
                /**
                 * reading filename from args parameters or user
                 */
                dataArray[0] = ui.readFilename(args, correctArgs, 2, "do odczytu: ");
                /**
                 * reading key from args parameters or user
                 */
                dataArray[1] = ui.readKey(args, correctArgs);
                /**
                 * reading text to encrypt/decrypt from file
                 */
                dataArray[2] = fileSupport.readFromFile(dataArray[0]);
            } catch (FileNotFoundException e) {
                ui.printText(e.getMessage());
            } catch (IOException e) {
                ui.printText(e.getMessage());
            }
            if (dataArray[2] == null) {
                correct = false;
                correctArgs = false;
            } else {
                correct = true;
            }
        }
        /**
         * return information about correction args
         */
        return correctArgs;
    }

    /**
     * Indirect method writing to file
     *
     * @param text
     * @param args
     * @param correctArgs to checking correction args
     */
    private void writeToFile(String text, String[] args, Boolean correctArgs) {
        try {
            String filename = ui.readFilename(args, correctArgs, 3, "do zapisu: ");
            fileSupport.writeToFile(filename, text);
        } catch (IOException e) {
            ui.printText(e.getMessage());
        }
    }

    /**
     * General encrypt method
     *
     * @param args
     */
    public void encrypt(String[] args) {
        String[] dataArray = new String[3];
        boolean correctArgs = readData(args, dataArray);
        String key = dataArray[1];
        String text = dataArray[2];
        try {
            text = cipherMachine.encrypt(text, key);
        } catch (WrongKeyException | NullPointerException e) {
            ui.printText(e.getMessage());
            return;
        }
        writeToFile(text, args, correctArgs);
    }

    /**
     * General decrypt method
     *
     * @param args
     */
    public void decrypt(String[] args) {
        String[] dataArray = new String[3];
        boolean correctArgs = readData(args, dataArray);
        String key = dataArray[1];
        String text = dataArray[2];
        try {
            text = cipherMachine.decrypt(text, key);
        } catch (WrongKeyException | NullPointerException e) {
            ui.printText(e.getMessage());
            return;
        }
        writeToFile(text, args, correctArgs);
    }

    /**
     * Indirection method choosing operation for encrypt or decrypt option.
     *
     * @param args
     * @return sign of operation
     */
    public char chooseOperation(String[] args) {
        return ui.chooseOperation(args);
    }

}

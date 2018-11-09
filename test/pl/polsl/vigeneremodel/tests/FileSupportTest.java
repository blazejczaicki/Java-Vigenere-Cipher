/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.vigeneremodel.tests;

import org.junit.Test;
import pl.polsl.vigeneremodel.FileSupport;
import static org.junit.Assert.*;

/**
 * @version 1.0
 * @author Błażej Czaicki
 */
public class FileSupportTest {

    /**
     * Test of readFromFile method, of class FileSupport.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadFromFile() throws Exception {
        String filename = "test.txt";
        FileSupport instance = new FileSupport();
        String expResult = "test tekst";
        String result = instance.readFromFile(filename);
        assertEquals(expResult, result);
    }

    /**
     * Test of writeToFile method, of class FileSupport.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteToFile() throws Exception {
        String filename = "testT.txt";
        String text = "Tekst!";
        FileSupport instance = new FileSupport();
        instance.writeToFile(filename, text);
    }

}

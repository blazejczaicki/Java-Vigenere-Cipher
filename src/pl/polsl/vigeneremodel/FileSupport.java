/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.vigeneremodel;

import java.io.*;
import java.io.FileNotFoundException;

/**
 * Model type Class which support file. Responds for reading and writing.
 *
 * @version 2.0
 * @author Błażej Czaicki
 */
public class FileSupport {

    /**
     * Method to reading from file.
     *
     * @param filename
     * @return text
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String readFromFile(String filename) throws FileNotFoundException, IOException {
        /**
         * Stroes reading text
         */
        String text = new String();
        /**
         * BufferReader to getting lines
         */
        BufferedReader br = null;
        File file = new File(filename);
        try {
            br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                text += line;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Nie udalo sie otworzyc pliku!");
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            if (br != null) {
                br.close();
            }
        }

        return text;
    }

    /**
     * Method writing to file
     *
     * @param filename
     * @param text
     * @throws IOException
     */
    public void writeToFile(String filename, String text) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(text);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

}

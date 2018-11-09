/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.vigenereview;

import java.util.Scanner;

/**
 * Class displays interface and getting data from user or args parameters.
 *
 * @version 2.0
 * @author Błażej Czaicki
 */
public class ConsoleInterface implements UserInterface {

    /**
     * Method checking correction of key
     *
     * @param key
     * @return compatibility with pattern
     */
    @Deprecated
    private boolean isLowerCase(String key) {
        return key.matches("[a-z]+");
    }

    @Override
    public String readKey(String[] args, boolean correctArgs) {
        String key;
        if (args.length == 4 && correctArgs) {
            key = args[1];
        } else {
            System.out.print("Podaj klucz (małe litery): ");
            Scanner sc = new Scanner(System.in);
            key = sc.nextLine();
        }
        return key;
    }

    @Override
    public String readFilename(String[] args, boolean correctArgs, int numberOfName, String nameOperation) {
        String filename;
        if (args.length == 4 && correctArgs) {
            filename = args[numberOfName];
        } else {
            System.out.print("Podaj nazwe pliku " + nameOperation);
            Scanner sc = new Scanner(System.in);
            filename = sc.nextLine();
        }
        return filename;
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }

    @Override
    public char chooseOperation(String[] args) {
        char c;
        if (args.length != 4) {
            System.out.println("    Wybierz operację \n szyfruj[s] deszyfruj[d] wyjscie[other]");
            Scanner sc = new Scanner(System.in);
            c = sc.next().charAt(0);
        } else {
            c = args[0].charAt(0);
        }
        return c;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.vigeneremodel.tests;

import org.junit.Test;
import pl.polsl.vigeneremodel.CipherMachine;
import static org.junit.Assert.*;
import org.junit.Ignore;
import pl.polsl.wrongkeyexception.WrongKeyException;

/**
 * Testing CipherMachine class
 *
 * @version 1.0
 * @author Błażej Czaicki
 */
public class CipherMachineTest {

    /**
     * Test of encrypt method, of class CipherMachine, checking that not correct
     * key is wrong.
     */
    @Test
    public void testEncryptWrongKeyTest() {
        String text = "TO JEST BARDZO TAJNY TEKST";
        String key = "Tajne99";                         //wrong key
        CipherMachine instance = new CipherMachine();
        try {
            instance.encrypt(text, key);
            fail("Exception not throw!");
        } catch (WrongKeyException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of encrypt method, of class CipherMachine, checking diagonally
     * encrytping and key the same size like text
     */
    @Test
    public void testEncryptTheSameKey() {
        String text = "abcdefghijklmnopqrstuvwxyz";
        String key = "abcdefghijklmnopqrstuvwxyz";
        CipherMachine instance = new CipherMachine();
        String expResult = "acegikmoqsuwyacegikmoqsuwy";
        String result = null;
        try {
            result = instance.encrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of encrypt method, of class CipherMachine, checking key shorter than
     * text. .
     */
    @Test
    public void testEncryptShortKey() {
        String text = "TODO review the generated test code.";
        String key = "short";
        CipherMachine instance = new CipherMachine();
        String expResult = "LVRF kwcwvp los xxflfrmwk hvll jcux.";
        String result = null;
        try {
            result = instance.encrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of encrypt method, of class CipherMachine, checking key longer than
     * text. .
     */
    @Test
    public void testEncryptLongKey() {
        String text = "short text";
        String key = "verylongcorrectkey";
        CipherMachine instance = new CipherMachine();
        String expResult = "nlfpe hrdv";
        String result = null;
        try {
            result = instance.encrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of encrypt method, of class CipherMachine, checking empty key (not
     * allowed).
     */
    @Test
    public void testEncryptEmptyKey() {
        String text = "hollow";
        String key = "";
        CipherMachine instance = new CipherMachine();
        try {
            instance.encrypt(text, key);
            fail("Exception not throw!");
        } catch (WrongKeyException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of encrypt method, of class CipherMachine, checking encrypting empty
     * text.
     */
    @Test
    public void testEncryptEmptyText() {
        String text = "";
        String key = "hollow";
        CipherMachine instance = new CipherMachine();
        String expResult = "";
        String result = null;
        try {
            result = instance.encrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of encrypt method, of class CipherMachine, checking method with
     * specific undecrypted signs .
     */
    @Test
    public void testEncryptSpecyficSigns() {
        String text = "1999..//\\2210-~~+-][    ''aaa";
        String key = "abc";
        CipherMachine instance = new CipherMachine();
        String expResult = "1999..//\\2210-~~+-][    ''abc";
        String result = null;
        try {
            result = instance.encrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of encrypt method, of class CipherMachine, checking text null
     */
    @Test
    public void testEncryptNullText() {
        String text = null;
        String key = "tetet";
        CipherMachine instance = new CipherMachine();
        try {
            instance.encrypt(text, key);
            fail("Exception not throw!");
        } catch (NullPointerException | WrongKeyException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of encrypt method, of class CipherMachine, checking key null
     */
    @Test
    public void testEncryptNullKey() {
        String text = "TO JEST BARDZO TAJNY TEKST";
        String key = null;                         //wrong key
        CipherMachine instance = new CipherMachine();
        try {
            instance.encrypt(text, key);
            fail("Exception not throw!");
        } catch (NullPointerException | WrongKeyException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of decrypt method, of class CipherMachine, checking that not correct
     * key is wrong.
     */
    @Test
    public void testDecryptWrongKeyTest() {
        String text = "Test.";
        String key = "Tet";                         //wrong key
        CipherMachine instance = new CipherMachine();
        try {
            instance.decrypt(text, key);
            fail("Exception not throw!");
        } catch (WrongKeyException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of decrypt method, of class CipherMachine, checking diagonally
     * decrytping and key the same size like text
     */
    @Test
    public void testDecryptTheSameKey() {
        String text = "acegikmoqsuwyacegikmoqsuwy";
        String key = "abcdefghijklmnopqrstuvwxyz";
        CipherMachine instance = new CipherMachine();
        String expResult = "abcdefghijklmnopqrstuvwxyz";
        String result = null;
        try {
            result = instance.decrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class CipherMachine, checking method for key
     * which is shorter than text.
     */
    @Test
    public void testDecryptShortKey() {
        String text = "LVRF kwcwvp los xxflfrmwk hvll jcux.";
        String key = "short";
        CipherMachine instance = new CipherMachine();
        String expResult = "TODO review the generated test code.";
        String result = null;
        try {
            result = instance.decrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class CipherMachine, checking method for key
     * which is longer than text.
     */
    @Test
    public void testDecryptLongKey() {
        String text = "nlfpe hrdv";
        String key = "verylongcorrectkey";
        CipherMachine instance = new CipherMachine();
        String expResult = "short text";
        String result = null;
        try {
            result = instance.decrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class CipherMachine, checking method with
     * empty key(wrong key).
     */
    @Test
    public void testDecryptEmptyKey() {
        String text = "hollow";
        String key = "";
        CipherMachine instance = new CipherMachine();
        try {
            instance.decrypt(text, key);
            fail("Exception not throw!");
        } catch (WrongKeyException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of decrypt method, of class CipherMachine, checking correction
     * method with empty text.
     */
    @Test
    public void testDecryptEmptyText() {
        String text = "";
        String key = "hollow";
        CipherMachine instance = new CipherMachine();
        String expResult = "";
        String result = null;
        try {
            result = instance.decrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class CipherMachine, checking method with
     * specific undecrypted signs .
     */
    @Test
    public void testdecryptSpecyficSigns() {
        System.out.println("encrypt");
        String text = "1999..//\\2210-~~+-][    ''";
        String key = "abc";
        CipherMachine instance = new CipherMachine();
        String expResult = "1999..//\\2210-~~+-][    ''";
        String result = null;
        try {
            result = instance.encrypt(text, key);
        } catch (WrongKeyException e) {
            fail(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class CipherMachine, checking text null
     */
    @Test
    public void testDecryptNullText() {
        String text = null;
        String key = "tetet";
        CipherMachine instance = new CipherMachine();
        try {
            instance.decrypt(text, key);
            fail("Exception not throw!");
        } catch (NullPointerException | WrongKeyException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of decrypt method, of class CipherMachine, checking key null
     */
    @Test
    public void testDecryptNullKey() {
        String text = "TO JEST BARDZO TAJNY TEKST";
        String key = null;                         //wrong key
        CipherMachine instance = new CipherMachine();
        try {
            instance.decrypt(text, key);
            fail("Exception not throw!");
        } catch (NullPointerException | WrongKeyException e) {
            assertTrue(true);
        }
    }

}

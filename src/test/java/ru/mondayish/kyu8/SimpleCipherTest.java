package ru.mondayish.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCipherTest {

    @Test
    public void basicDecipherTests(){
        assertEquals("hello world!", SimpleCipher.decipher("|-|3||0 w0r||)!"));
//        assertEquals();
//        assertEquals();
    }
}
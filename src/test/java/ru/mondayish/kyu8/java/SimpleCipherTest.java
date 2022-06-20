package ru.mondayish.kyu8.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCipherTest {

    private static final Map<String, String> REPLACE_SYMBOLS = new HashMap<String, String>() {{
        put("a", "@");
        put("b", "6");
        put("c", "c");
        put("d", "|)");
        put("e", "3");
        put("f", "|=");
        put("g", "g");
        put("h", "|-|");
        put("i", "1");
        put("j", "_!");
        put("k", "|<");
        put("l", "|");
        put("m", "m");
        put("n", "n");
        put("o", "0");
        put("p", "|*");
        put("q", "q");
        put("r", "r");
        put("s", "$");
        put("t", "7");
        put("u", "u");
        put("v", "v");
        put("w", "w");
        put("x", ")(");
        put("y", "-/");
        put("z", "-/_");
    }};

    @Test
    public void basicDecipherTests() {
        assertEquals("hello world!", SimpleCipher.decipher("|-|3||0 w0r||)!"));
        assertEquals("how are you?", SimpleCipher.decipher("|-|0w @r3 -/0u?"));
        assertEquals("this is simple test", SimpleCipher.decipher("7|-|i$ 1$ $1m|*|3 73$7"));
    }

    @Test
    public void withoutChangesDecipherTests() {
        assertEquals("hello world!", SimpleCipher.decipher("hello world!"));
        assertEquals("  some text... ", SimpleCipher.decipher("  some text... "));
        assertEquals("spring data jpa", SimpleCipher.decipher("spring data jpa"));
    }

    @Test
    public void withoutLettersDecipherTests() {
        assertEquals("", SimpleCipher.decipher(""));
        assertEquals("   ", SimpleCipher.decipher("   "));
        assertEquals("!#%..//(", SimpleCipher.decipher("!#%..//("));
    }

    @Test
    public void repeatableLettersDecipherTests() {
        assertEquals("hh.ru", SimpleCipher.decipher("|-||-|.ru"));
        assertEquals("hheeellloo", SimpleCipher.decipher("|-||-|333|||00"));
        assertEquals("qqqq wwww eee r tttt yyy", SimpleCipher.decipher("qqqq wwww 333 r 7777 -/-/-/"));
    }

    @Test
    public void sameSymbolsDecipherTests() {
        assertEquals("lxlx", SimpleCipher.decipher("|)(|)("));
        assertEquals("hhlhh", SimpleCipher.decipher("|-||-|||-||-|"));
        assertEquals("lklflpll", SimpleCipher.decipher("||<||=||*||"));
    }

    @Test
    public void randomLettersDecipherTests() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            StringBuilder expected = new StringBuilder();
            int expectedLength = 1 + random.nextInt(100);
            for (int j = 0; j < expectedLength; j++) {
                expected.append((char) ('a' + random.nextInt(26)));
            }

            String cipher = Arrays.stream(expected.toString().split(""))
                    .map(REPLACE_SYMBOLS::get).collect(Collectors.joining());
            assertEquals(expected.toString(), SimpleCipher.decipher(cipher));
        }
    }
}
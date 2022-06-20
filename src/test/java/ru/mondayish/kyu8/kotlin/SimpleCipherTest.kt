package ru.mondayish.kyu8.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*
import java.util.stream.Collectors
import kotlin.random.Random

internal class SimpleCipherTest {

    private val replaceSymbols: Map<String, String> = mapOf(
        Pair("a", "@"), Pair("b", "6"), Pair("c", "c"), Pair("d", "|)"), Pair("e", "3"), Pair("f", "|="),
        Pair("g", "g"), Pair("h", "|-|"), Pair("i", "1"), Pair("j", "_!"), Pair("k", "|<"), Pair("l", "|"),
        Pair("m", "m"), Pair("n", "n"), Pair("o", "0"), Pair("p", "|*"), Pair("q", "q"), Pair("r", "r"),
        Pair("s", "$"), Pair("t", "7"), Pair("u", "u"), Pair("v", "v"), Pair("w", "w"), Pair("x", ")("),
        Pair("y", "-/"), Pair("z", "-/_")
    )

    @Test
    fun basicDecipherTests() {
        assertEquals("hello world!", SimpleCipher.decipher("|-|3||0 w0r||)!"))
        assertEquals("how are you?", SimpleCipher.decipher("|-|0w @r3 -/0u?"))
        assertEquals("this is simple test", SimpleCipher.decipher("7|-|i$ 1$ $1m|*|3 73$7"))
    }

    @Test
    fun withoutChangesDecipherTests() {
        assertEquals("hello world!", SimpleCipher.decipher("hello world!"))
        assertEquals("  some text... ", SimpleCipher.decipher("  some text... "))
        assertEquals("spring data jpa", SimpleCipher.decipher("spring data jpa"))
    }

    @Test
    fun withoutLettersDecipherTests() {
        assertEquals("", SimpleCipher.decipher(""))
        assertEquals("   ", SimpleCipher.decipher("   "))
        assertEquals("!#%..//(", SimpleCipher.decipher("!#%..//("))
    }

    @Test
    fun repeatableLettersDecipherTests() {
        assertEquals("hh.ru", SimpleCipher.decipher("|-||-|.ru"))
        assertEquals("hheeellloo", SimpleCipher.decipher("|-||-|333|||00"))
        assertEquals("qqqq wwww eee r tttt yyy", SimpleCipher.decipher("qqqq wwww 333 r 7777 -/-/-/"))
    }

    @Test
    fun sameSymbolsDecipherTests() {
        assertEquals("lxlx", SimpleCipher.decipher("|)(|)("))
        assertEquals("hhlhh", SimpleCipher.decipher("|-||-|||-||-|"))
        assertEquals("lklflpll", SimpleCipher.decipher("||<||=||*||"))
    }

    @Test
    fun randomLettersDecipherTests() {
        for (i in 0..99) {
            val expected = StringBuilder()
            val expectedLength = 1 + Random.nextInt(100)
            for (j in 0 until expectedLength) {
                expected.append(('a'.code + Random.nextInt(26)).toChar())
            }
            val cipher = Arrays.stream(expected.toString().split("")
                .dropWhile { it.isEmpty() }.dropLastWhile { it.isEmpty() }
                .toTypedArray()).map { key: String? -> replaceSymbols[key] }.collect(Collectors.joining())
            assertEquals(expected.toString(), SimpleCipher.decipher(cipher))
        }
    }
}
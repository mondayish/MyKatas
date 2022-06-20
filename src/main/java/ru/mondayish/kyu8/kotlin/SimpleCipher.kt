package ru.mondayish.kyu8.kotlin

object SimpleCipher {

    fun decipher(message: String): String = message.replace("0", "o")
        .replace("1", "i").replace("3", "e").replace("$", "s")
        .replace("6", "b").replace("7", "t").replace("_!", "j")
        .replace("-/_", "z").replace("-/", "y")
        .replace(")(", "x").replace("@", "a")
        .replace("|<", "k").replace("|)", "d")
        .replace("|=", "f").replace("|-|", "h")
        .replace("|*", "p").replace("|", "l")
}
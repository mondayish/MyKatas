package ru.mondayish.kyu8;

public class SimpleCipher {

    public static String decipher(String message) {
        return message.replaceAll("0", "o").replaceAll("1", "i")
                .replaceAll("3", "e").replaceAll("\\$", "s")
                .replaceAll("6", "b").replaceAll("7", "t")
                .replaceAll("-/_", "z").replaceAll("-/", "y")
                .replaceAll("\\)\\(", "x").replaceAll("@", "a")
                .replaceAll("\\|<", "k").replaceAll("\\|\\)", "d")
                .replaceAll("\\|=", "f").replaceAll("\\|-\\|", "h")
                .replaceAll("_!", "j").replaceAll("\\|\\*", "p")
                .replaceAll("\\|", "l");
    }
}

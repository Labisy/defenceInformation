package ru.stepchenkov.labs.lab2.controller;

import ru.stepchenkov.labs.lab2.model.Vegener;

public record VegenenerController(Vegener vegener) {

    public String encrypt(final String text, final String key) {
        StringBuilder encrypt = new StringBuilder();
        final int keyLen = key.length();
        for (int i = 0, len = text.length(); i < len; i++) {
            encrypt.append((char) (((text.charAt(i) + key.charAt(i % keyLen) - 2 * vegener.bias()) % vegener.letters()) + vegener.bias()));
        }
        return encrypt.toString();
    }

    public String decrypt(final String cipher, final String key) {
        StringBuilder decrypt = new StringBuilder();
        final int keyLen = key.length();
        for (int i = 0, len = cipher.length(); i < len; i++) {
            decrypt.append((char) (((cipher.charAt(i) - key.charAt(i % keyLen) + vegener.letters()) % vegener.letters()) + vegener.bias()));
        }
        return decrypt.toString();
    }
}

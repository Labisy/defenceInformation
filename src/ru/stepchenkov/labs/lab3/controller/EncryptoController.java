package ru.stepchenkov.labs.lab3.controller;

import ru.stepchenkov.labs.lab3.model.Vegener;

public class EncryptoController {
    private final Vegener vegener;
    private String key;

    public EncryptoController(Vegener vegener) {
        this.vegener = vegener;
    }

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

    public boolean checkKey(String anotherKey, String inputText) {
        return key.equals(encrypt(inputText, anotherKey) + encrypt(anotherKey, anotherKey));
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

package ru.stepchenkov.labs.lab4.controller;

import ru.stepchenkov.labs.lab4.model.GfgModel;

public class GfgController {
    private GfgModel model;

    private int[] lcm() {
        int[] randomNums = model.getRandomNum();
        randomNums[0] = model.getY0();
        for (int i = 1; i < randomNums.length; i++) {
            randomNums[i] = ((randomNums[i - 1] * model.getA()) + model.getB()) % model.getM();
        }

        return randomNums;
    }

    public String encrypt(String word) {
        StringBuilder out = new StringBuilder();
        int[] encryptNum = lcm();
        char[] letters = word.toCharArray();

        for (int i = 0; i < encryptNum.length; i++) {
            out.append((char)(letters[i] + encryptNum[i]));
        }

        return out.toString();
    }

    public String decrypt(String word) {
        StringBuilder out = new StringBuilder();
        int[] encryptNum = lcm();
        char[] letters = word.toCharArray();

        for (int i = 0; i < encryptNum.length; i++) {
            out.append((char)(letters[i] - encryptNum[i]));
        }

        return out.toString();
    }
    public GfgModel getModel() {
        return model;
    }

    public void setModel(GfgModel model) {
        this.model = model;
    }
}

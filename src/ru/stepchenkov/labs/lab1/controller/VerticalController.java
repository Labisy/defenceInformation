package ru.stepchenkov.labs.lab1.controller;

import java.util.Arrays;

public class VerticalController {
    private int countI = 0;

    public String[][] getTable(String word, int keyLength) {
        countI = (int) Math.ceil(word.length() / (keyLength * 1.0));
        String[][] resultTable = new String[countI][keyLength];
        int countLetter = 0;

        for (int i = 0; i < countI; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (countLetter == word.length()) {
                    resultTable[i][j] = "-";
                } else {
                    resultTable[i][j] = Character.toString(word.charAt(countLetter));
                    countLetter++;
                }
            }
        }
        return resultTable;
    }

    public String encrypt(String[][] resultTable, String key) {
        int[] arrKey = Arrays.stream(key.split("")).mapToInt(Integer::parseInt).toArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < key.length(); i++) {
            int position = getPosition(arrKey);
            for (int j = 0; j < countI; j++) {
                result.append(resultTable[j][position]);
            }
        }

        return result.toString();
    }

    private int getPosition(int[] value) {
        int min = Arrays.stream(value).min().getAsInt();
        for (int i = 0; i < value.length; i++) {
            if (min == value[i]) {
                value[i] = Integer.MAX_VALUE;
                return i;
            }
        }
        return 0;
    }

    public String decrypt(String[][] outputTable, int keyLen) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < countI; i++) {
            for (int j = 0; j < keyLen; j++) {
                if (outputTable[i][j].equals("-")) continue;
                result.append(outputTable[i][j]);
            }
        }
        return result.toString();
    }

    public String[][] getOutputTable(String word, String key) {
        checkCountI(word, key);

        int[] arrKey = Arrays.stream(key.split("")).mapToInt(Integer::parseInt).toArray();
        String[] tempArr = word.split("");
        String[][] outputArr = new String[countI][key.length()];

        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            int position = getPosition(arrKey);
            for (int j = 0; j < countI; j++) {
                if (index == tempArr.length) break;
                outputArr[j][position] = tempArr[index];

                index++;
            }
        }

        return outputArr;
    }

    private void checkCountI(String word, String key) {
        if (countI == 0) {
            countI = (int) Math.ceil(word.length() / (key.length() * 1.0));
        }
    }

}

package ru.stepchenkov.labs.lab5.controller;

import ru.stepchenkov.labs.lab5.model.EncryptModel;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class CoderController {
    private EncryptModel model;

    public CoderController(EncryptModel model) {
        this.model = model;
    }

    public void getRandomNumberInts(){
        Random random = new Random();
        model.setKeySet(random.ints(1,(8+1)).limit(13).toArray());
    }

    public String encrypt(String enter) {
        String temp = Arrays.stream(model.getKeySet()).boxed().map(String::valueOf).collect(Collectors.joining());
        BigInteger key = new BigInteger(getBinFromArr(temp));
        System.out.println(key);
        BigInteger message = new BigInteger(getBinFromArr(enter));
        System.out.println(message);

        String res = key.xor(message).toString();
        System.out.println(res);
        return res;
    }

    private String getBinFromArr(String enter) {
        StringBuilder sb = new StringBuilder();
        char[] arr = enter.toCharArray();

        for (char in : arr) {
            sb.append(Integer.toBinaryString(in));
        }

        return sb.toString();
    }

    public EncryptModel getModel() {
        return model;
    }
}

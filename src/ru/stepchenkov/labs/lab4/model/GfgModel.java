package ru.stepchenkov.labs.lab4.model;

public class GfgModel {
    private int a;
    private int b;
    private int m;
    private int y0;
    private int[] randomNum;

    public GfgModel(int a, int b, int m, int y0, int[] randomNum) {
        this.a = a;
        this.b = b;
        this.m = m;
        this.y0 = y0;
        this.randomNum = randomNum;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }

    public int[] getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int[] randomNum) {
        this.randomNum = randomNum;
    }
}

package ru.stepchenkov.labs.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] intArr = new int[3];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = sc.nextInt();
        }
        sc.close();

        for (int in: intArr) {
            System.out.println(in);
            // почему тут вывод без -1 идет не с 0 индекса?
        }
    }
}

package com.example.parameter.callbyvalue;

public class PrimitiveType {

    public static void main(String[] args) {
        int x = 1;
        int y = 2;

        // before modification
        System.out.println(x == 1);
        System.out.println(y == 2);

        modify(x, y);

        System.out.println(x == 1);
        System.out.println(y == 2);
    }

    private static void modify(int x1, int x2) {
        x1 = 5;
        x2 = 10;
    }
}

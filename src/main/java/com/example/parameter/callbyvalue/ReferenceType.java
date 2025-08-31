package com.example.parameter.callbyvalue;

public class ReferenceType {

    public static void main(String[] args) {
        A a = new A(1);
        B b = new B(1);

        System.out.println(a.num == 1);
        System.out.println(b.num == 1);

        modify(a, b);
        System.out.println(a.num == 2);
        System.out.println(b.num == 1);

        change(a, b);
        System.out.println(a.num == 3);
        System.out.println(b.num == 2);
    }

    private static class A {
        public int num;

        public A(int num) {
            this.num = num;
        }
    }

    private static class B {
        public int num;
        public B(int num) {
            this.num = num;
        }
    }

    private static void modify(A a, B b) {
        a.num++;

        b = new B(1);
        b.num++;
    }

    private static void change(A a, B b) {
        a.num++;
        b.num++;
    }
}

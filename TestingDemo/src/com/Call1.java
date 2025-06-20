package com;

public class Call1 {
    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Call1 c = new Call1();
        System.out.println(c.add(100, 200)); // actual: 300
        System.out.println(c.sub(200, 100));
        System.out.println(c.mul(10, 20));   // actual: 200
        System.out.println(c.div(200, 100)); // 2
    }
}

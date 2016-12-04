package com.laurengranger;

public class Main {

    public static void main(String[] args) {
        DoorCodeCalculator doorCodeCalculator = new DoorCodeCalculator();
        String code = doorCodeCalculator.code();
        System.out.print(code);
    }
}


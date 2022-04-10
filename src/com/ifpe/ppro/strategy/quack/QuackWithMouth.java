package com.ifpe.ppro.strategy.quack;

public class QuackWithMouth implements QuackBehavior {
    @Override
    public void performQuack() {
        System.out.println("I quack with my mouth");
    }
}

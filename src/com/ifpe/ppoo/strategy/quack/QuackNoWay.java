package com.ifpe.ppoo.strategy.quack;

public class QuackNoWay implements QuackBehavior{
    @Override
    public void performQuack() {
        System.out.println("...");
    }
}

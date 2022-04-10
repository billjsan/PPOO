package com.ifpe.ppro.strategy.quack;

public class QuackNoWay implements QuackBehavior{
    @Override
    public void performQuack() {
        System.out.println("...");
    }
}

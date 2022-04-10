package com.ifpe.ppro.strategy.quack;

public class QuackWithMegaPhone implements QuackBehavior{
    @Override
    public void performQuack() {
        System.out.println("I quack whit my megaphone");
    }
}

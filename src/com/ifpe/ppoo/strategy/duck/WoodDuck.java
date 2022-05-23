package com.ifpe.ppoo.strategy.duck;

public class WoodDuck extends Duck{

    public WoodDuck() {
        super();
    }

    @Override
    public void display() {
        System.out.println("I display like a wood piece");
    }

}

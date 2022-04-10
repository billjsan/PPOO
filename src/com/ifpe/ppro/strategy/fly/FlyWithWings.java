package com.ifpe.ppro.strategy.fly;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void performFly() {
        System.out.println("I fly with my wings");
    }
}

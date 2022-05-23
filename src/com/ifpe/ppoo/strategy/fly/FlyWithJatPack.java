package com.ifpe.ppoo.strategy.fly;

public class FlyWithJatPack implements FlyBehavior{
    @Override
    public void performFly() {
        System.out.println("I fly with my jetPack");
    }
}

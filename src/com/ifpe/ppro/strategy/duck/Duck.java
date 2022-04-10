package com.ifpe.ppro.strategy.duck;

import com.ifpe.ppro.strategy.fly.FlyBehavior;
import com.ifpe.ppro.strategy.quack.QuackBehavior;

public abstract class Duck {

    private FlyBehavior fb;
    private QuackBehavior qb;
    private String name;

    public Duck() {
    }

    public abstract void display();

    public void performQuack(){
        qb.performQuack();
    }

    public void performFly(){
        fb.performFly();
    }

    public FlyBehavior getFlyBehavior() {
        return fb;
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.fb = fb;
    }

    public QuackBehavior getQuackBehavior() {
        return qb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.qb = qb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

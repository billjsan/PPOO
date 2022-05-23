package com.ifpe.ppoo.strategy;

import com.ifpe.ppoo.strategy.atividade.behavior.Sort;
import com.ifpe.ppoo.strategy.atividade.entities.ColumnNumbers;
import com.ifpe.ppoo.strategy.atividade.entities.LineNumbers;
import com.ifpe.ppoo.strategy.atividade.behavior.BubleSort;
import com.ifpe.ppoo.strategy.atividade.behavior.InsertionSort;
import com.ifpe.ppoo.strategy.duck.RedHeadDuck;
import com.ifpe.ppoo.strategy.duck.WoodDuck;
import com.ifpe.ppoo.strategy.fly.FlyWithPower;
import com.ifpe.ppoo.strategy.fly.FlyWithWings;
import com.ifpe.ppoo.strategy.quack.QuackNoWay;
import com.ifpe.ppoo.strategy.quack.QuackWithMouth;

import java.util.Arrays;

public class StrategyTest {

    public static void strategySortPlay(){

        int[] numbers = {1,3,5,9,20,54,12,54354,14,54,54,51,14,25,61,14,5565,15545};

        ColumnNumbers cNumbers = new ColumnNumbers();
        cNumbers.setSortImpl(new BubleSort());
        cNumbers.sort(numbers);
        cNumbers.showCurrentSortedNumbers();

        LineNumbers lNumbers = new LineNumbers();
        lNumbers.setSortImpl(new InsertionSort());
        lNumbers.sort(numbers);
        lNumbers.showCurrentSortedNumbers();

        LineNumbers obj = new LineNumbers();
        obj.setSortImpl(new Sort() {
            @Override
            public int[] sort(int[] numbers) {

                Arrays.fill(numbers, -1);
                return numbers;
            }

            @Override
            public String myName() {
                return "I'm Anonymous implementation";
            }
        });

        obj.sort(numbers);
        obj.showCurrentSortedNumbers();

    }

    public static void strategyDuckPlay(){

        RedHeadDuck redHeadDuck = new RedHeadDuck();

        redHeadDuck.setName("meu patinho cabeça vermelha");
        redHeadDuck.setFlyBehavior(new FlyWithPower());
        redHeadDuck.setQuackBehavior(new QuackNoWay());

        System.out.println("Meu nome é: " + redHeadDuck.getName());
        redHeadDuck.performFly();
        redHeadDuck.performQuack();
        redHeadDuck.display();

        WoodDuck woodDuck = new WoodDuck();
        woodDuck.setName("Sou um patinho de madeira");
        woodDuck.setFlyBehavior(new FlyWithWings());
        woodDuck.setQuackBehavior(new QuackWithMouth());

        System.out.println("Meu nome é: " + woodDuck.getName());
        woodDuck.performFly();
        woodDuck.performQuack();
        woodDuck.display();
    }
}

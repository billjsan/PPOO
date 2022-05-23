package com.ifpe.ppoo.strategy.atividade.entities;

public class ColumnNumbers extends SortClass {

    @Override
    public void showCurrentSortedNumbers() {

        System.out.println("Sou um sorteador de numeros usando: " + getSortImpl().myName());
        for (int sortedNumber : currentSortedNumbers) {
            System.out.println(sortedNumber);
        }
    }
}

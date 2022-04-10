package com.ifpe.ppro.strategy.atividade.entities;

public class LineNumbers extends SortClass {
    @Override
    public void showCurrentSortedNumbers() {

        System.out.println("\n\nSou um outro sorteador de numeros usando: " + getSortImpl().myName());
        for (int sortedNumber : currentSortedNumbers) {
            System.out.print(sortedNumber + " ");
        }
    }
}

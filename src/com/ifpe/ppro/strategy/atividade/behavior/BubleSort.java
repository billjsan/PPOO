package com.ifpe.ppro.strategy.atividade.behavior;

public class BubleSort implements Sort {
    @Override
    public int[] sort(int [] numbers) {

        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers.length -1;j++) {
                if(numbers[j] > numbers[j+1]){
                    int aux;
                    aux = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] =  aux;
                }
            }
        }
        return numbers;
    }

    @Override
    public String myName() {
        return BubleSort.class.getSimpleName();
    }
}

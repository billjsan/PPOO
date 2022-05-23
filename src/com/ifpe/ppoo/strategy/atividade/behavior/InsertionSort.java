package com.ifpe.ppoo.strategy.atividade.behavior;

public class InsertionSort implements Sort{
    @Override
    public int[] sort(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {
            int j = i;
            while (j > 0 && numbers[j] < numbers[j-1]) {
                int aux = numbers[j];
                numbers[j] = numbers[j - 1];
                numbers[j - 1] = aux;
                j -= 1;
            }
        }
        return numbers;
    }

    @Override
    public String myName() {
        return InsertionSort.class.getSimpleName();
    }
}

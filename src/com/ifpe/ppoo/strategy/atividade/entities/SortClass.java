package com.ifpe.ppoo.strategy.atividade.entities;

import com.ifpe.ppoo.strategy.atividade.behavior.Sort;

public abstract class SortClass {
    private Sort sortImpl;
    protected int[] currentSortedNumbers;

    public SortClass() {
    }

    public void setSortImpl(Sort sortImpl) {
        this.sortImpl = sortImpl;
    }

    public Sort getSortImpl() {
        return sortImpl;
    }

    public int[] sort(int[] numbers){

        currentSortedNumbers = sortImpl.sort(numbers);
        return currentSortedNumbers;
    }

    protected abstract void showCurrentSortedNumbers();
}

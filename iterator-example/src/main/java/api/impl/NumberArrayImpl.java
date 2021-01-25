package api.impl;

import api.NumberArray;
import api.NumberIterator;

import java.util.Arrays;

public class NumberArrayImpl implements NumberArray {
    private final Integer[] numberArray;

    public NumberArrayImpl(Integer[] numberArray) {
        this.numberArray = numberArray;
    }

    public Integer[] getOddNumber() {
        return Arrays.stream(numberArray).filter(i -> i % 2 == 1).toArray(Integer[]::new);
    }

    public Integer[] getEvenNumber() {
        return Arrays.stream(numberArray).filter(i -> i % 2 == 0).toArray(Integer[]::new);
    }

    @Override
    public NumberIterator createOddNumberIterator() {
        return new NumberIteratorImpl(this, "odd");
    }

    @Override
    public NumberIterator createEvenNumberIterator() {
        return new NumberIteratorImpl(this, "even");
    }
}

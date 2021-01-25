package api.impl;

import api.NumberIterator;

public class NumberIteratorImpl implements NumberIterator {
    private final NumberArrayImpl array;
    private Integer[] cache;
    private final String type;
    private Integer currentPosition;

    public NumberIteratorImpl(NumberArrayImpl array, String type) {
        this.array = array;
        this.currentPosition = 0;
        this.type = type;
    }

    private void lazyInit() {
        if (type.equals("even")) {
            cache = array.getEvenNumber();
        }
        if (type.equals("odd")) {
            cache = array.getOddNumber();
        }
    }

    @Override
    public Integer getNext() {
        if (hasMore()) {
            currentPosition++;
            return cache[currentPosition - 1];
        }
        return null;
    }

    @Override
    public boolean hasMore() {
        lazyInit();
        return currentPosition < cache.length;
    }
}

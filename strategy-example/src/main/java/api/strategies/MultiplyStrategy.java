package api.strategies;

import api.Strategy;

public class MultiplyStrategy implements Strategy {
    @Override
    public Integer execute(Integer a, Integer b) {
        return a * b;
    }
}

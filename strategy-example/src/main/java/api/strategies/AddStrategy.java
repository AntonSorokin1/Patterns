package api.strategies;

import api.Strategy;

public class AddStrategy implements Strategy {
    @Override
    public Integer execute(Integer a, Integer b) {
        return a + b;
    }
}

package entity;

import api.Strategy;

public class Calculator {
    private Strategy strategy;

    public Calculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public Integer count(Integer a, Integer b) {
        return strategy.execute(a, b);
    } 
}

package entity.objects;

import entity.Animal;

public class Duck extends Animal {
    @Override
    public String move() {
        return "Двигается везде";
    }

    @Override
    public String sleep() {
        return "В спячку не впадает";
    }
}

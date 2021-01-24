package entity.impl;

import entity.Prototype;

import java.util.Objects;

public class Sheep implements Prototype<Sheep> {
    private Integer age;
    private String name;
    private String color;

    public Sheep(Integer age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Sheep getClone() {
        return new Sheep(age, name, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sheep sheep = (Sheep) o;
        return Objects.equals(age, sheep.age) && Objects.equals(name, sheep.name) && Objects.equals(color, sheep.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, color);
    }
}

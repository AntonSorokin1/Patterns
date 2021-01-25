package entity;

public interface Shape {
    default void move(Integer x, Integer y) {
        //
    }
    default void drew() {
        //
    }
    String accept(Visitor visitor);
}

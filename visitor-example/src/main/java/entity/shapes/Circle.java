package entity.shapes;

import entity.Shape;
import entity.Visitor;

public class Circle implements Shape {
    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

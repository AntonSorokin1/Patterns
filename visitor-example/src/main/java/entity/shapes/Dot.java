package entity.shapes;

import entity.Shape;
import entity.Visitor;

public class Dot implements Shape {
    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

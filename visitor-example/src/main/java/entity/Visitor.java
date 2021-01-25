package entity;

import entity.shapes.Circle;
import entity.shapes.Dot;
import entity.shapes.Rectangle;

public interface Visitor {
    String visit(Dot dot);
    String visit(Circle circle);
    String visit(Rectangle rectangle);
}

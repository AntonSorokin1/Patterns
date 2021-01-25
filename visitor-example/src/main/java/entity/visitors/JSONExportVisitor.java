package entity.visitors;

import entity.Visitor;
import entity.shapes.Circle;
import entity.shapes.Dot;
import entity.shapes.Rectangle;

public class JSONExportVisitor implements Visitor {
    @Override
    public String visit(Dot dot) {
        return "Export dot";
    }

    @Override
    public String visit(Circle circle) {
        return "Export circle";
    }

    @Override
    public String visit(Rectangle rectangle) {
        return "Export rectangle";
    }
}

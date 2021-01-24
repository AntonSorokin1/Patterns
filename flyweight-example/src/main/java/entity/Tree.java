package entity;

import java.awt.*;

public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TreeType getType() {
        return type;
    }

    public void setType(TreeType type) {
        this.type = type;
    }

    public void draw(Canvas canvas) {
        type.draw(canvas, this.x, this.y);
    }
}

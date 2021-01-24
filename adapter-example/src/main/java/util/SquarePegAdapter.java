package util;

import entity.RoundPeg;
import entity.SquarePeg;

public class SquarePegAdapter extends RoundPeg {
    public SquarePegAdapter(SquarePeg squarePeg) {
        super(squarePeg.getWidth() * Math.sqrt(2) / 2);
    }
}

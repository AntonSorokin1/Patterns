package api.commands;

import api.Command;
import entity.Unit;

public class MoveLeftCommand extends Command {
    public MoveLeftCommand(Unit unit) {
        super(unit);
    }

    @Override
    public void execute() {
        if (!isExecuted()) {
            unit.setX(unit.getX() - 1);
            super.execute();
        }
    }

    @Override
    public void undo() {
        if (isExecuted()) {
            unit.setX(unit.getX() + 1);
            super.undo();
        }
    }
}

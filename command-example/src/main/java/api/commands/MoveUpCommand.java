package api.commands;

import api.Command;
import entity.Unit;

public class MoveUpCommand extends Command {
    public MoveUpCommand(Unit unit) {
        super(unit);
    }

    @Override
    public void execute() {
        if (!isExecuted()) {
            unit.setY(unit.getY() - 1);
            super.execute();
        }
    }

    @Override
    public void undo() {
        if (isExecuted()) {
            unit.setY(unit.getY() + 1);
            super.undo();
        }
    }
}

package api.commands;

import api.Command;
import entity.Unit;

public class MoveDownCommand extends Command {
    public MoveDownCommand(Unit unit) {
        super(unit);
    }

    @Override
    public void execute() {
        if (!isExecuted()) {
            unit.setY(unit.getY() + 1);
            super.execute();
        }
    }

    @Override
    public void undo() {
        if (isExecuted()) {
            unit.setY(unit.getY() - 1);
            super.undo();
        }
    }
}

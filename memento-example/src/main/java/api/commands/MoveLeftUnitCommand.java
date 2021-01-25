package api.commands;

import api.UnitCommand;
import entity.Unit;

public class MoveLeftUnitCommand extends UnitCommand {
    public MoveLeftUnitCommand(Unit unit) {
        super(unit);
    }

    @Override
    public void execute() {
        if (snapshot == null) {
            makeBackup();
            unit.setX(unit.getX() - 1);
        }
    }
}

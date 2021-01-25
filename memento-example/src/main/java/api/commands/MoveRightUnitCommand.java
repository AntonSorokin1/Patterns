package api.commands;

import api.UnitCommand;
import entity.Unit;

public class MoveRightUnitCommand extends UnitCommand {
    public MoveRightUnitCommand(Unit unit) {
        super(unit);
    }

    @Override
    public void execute() {
        if (snapshot == null) {
            makeBackup();
            unit.setX(unit.getX() + 1);
        }
    }
}

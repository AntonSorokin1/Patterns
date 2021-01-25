package api.commands;

import api.UnitCommand;
import entity.Unit;

public class MoveUpUnitCommand extends UnitCommand {
    public MoveUpUnitCommand(Unit unit) {
        super(unit);
    }

    @Override
    public void execute() {
        if (snapshot == null) {
            makeBackup();
            unit.setY(unit.getY() - 1);
        }
    }
}

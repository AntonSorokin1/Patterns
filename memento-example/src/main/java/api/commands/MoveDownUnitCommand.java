package api.commands;

import api.UnitCommand;
import entity.Unit;

public class MoveDownUnitCommand extends UnitCommand {
    public MoveDownUnitCommand(Unit unit) {
        super(unit);
    }

    @Override
    public void execute() {
        if (snapshot == null) {
            makeBackup();
            unit.setY(unit.getY() + 1);
        }
    }
}

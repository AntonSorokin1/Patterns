package api;

import entity.Unit;
import entity.UnitSnapshot;

public abstract class UnitCommand implements Command {
    protected Unit unit;
    protected UnitSnapshot snapshot;

    protected UnitCommand(Unit unit) {
        this.unit = unit;
    }

    protected void makeBackup() {
        snapshot = unit.createSnapshot();
    }

    @Override
    public void undo() {
        if (snapshot != null) {
            snapshot.restore();
        }
        snapshot = null;
    }
}

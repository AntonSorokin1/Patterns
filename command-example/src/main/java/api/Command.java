package api;

import entity.Unit;

public abstract class Command {
    protected final Unit unit;
    protected boolean executed;

    protected Command(Unit unit) {
        this.unit = unit;
        this.executed = false;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void execute() {
        this.executed = true;
    }

    public void undo() {
        this.executed = false;
    }
}

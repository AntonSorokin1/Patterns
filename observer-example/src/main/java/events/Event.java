package events;

public class Event {
    private EventCondition condition;
    private EventAction action;

    public Event(EventCondition condition, EventAction action) {
        this.condition = condition;
        this.action = action;
    }

    public EventCondition getCondition() {
        return condition;
    }

    public void setCondition(EventCondition condition) {
        this.condition = condition;
    }

    public EventAction getAction() {
        return action;
    }

    public void setAction(EventAction action) {
        this.action = action;
    }

    public void run(Object... params) {
        if (condition == null) action.start(params);
        if (condition != null && condition.check(params)) action.start(params);
    }
}

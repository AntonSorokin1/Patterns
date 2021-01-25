package events;

public interface EventCondition {
    boolean check(Object... params);
}

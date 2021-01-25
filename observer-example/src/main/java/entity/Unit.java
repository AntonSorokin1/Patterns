package entity;

import events.EventManager;
import events.EventType;

public class Unit {
    private int health;
    private final EventManager events;

    public Unit(int health) {
        this.health = health;
        events = new EventManager(
                EventType.UNIT_DIED,
                EventType.UNIT_TAKES_DAMAGE
        );
    }

    public EventManager getEvents() {
        return events;
    }

    public void takeDamage(Integer value) {
        events.run(EventType.UNIT_TAKES_DAMAGE, value);
        health -= value;
        if (!isAlive()) events.run(EventType.UNIT_DIED);
    }

    public boolean isAlive() {
        return health > 0;
    }
}

package events;

import java.util.*;

public class EventManager {
    private final Map<EventType, List<Event>> events = new EnumMap<>(EventType.class);

    public EventManager(EventType... eventTypes) {
        for (EventType event : eventTypes) {
            events.put(event, new ArrayList<>());
        }
    }

    public void subscribe(EventType eventType, Event event) {
        events.get(eventType).add(event);
    }

    public void unsubscribe(EventType eventType, Event event) {
        events.get(eventType).remove(event);
    }

    public void run(EventType eventType, Object... params) {
        for (Event event : events.get(eventType)) {
            event.run(params);
        }
    }
}
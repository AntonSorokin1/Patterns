import entity.Unit;
import events.Event;
import events.EventType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ObserverTest {
    @Test
    void checkUnitTakeDamageEvent() {
        final Boolean[] flag = {false};
        Unit john = new Unit(100);
        john.getEvents().subscribe(EventType.UNIT_TAKES_DAMAGE, new Event(
                null,
                params -> flag[0] = true

        ));
        john.takeDamage(5);
        Assertions.assertTrue(flag[0]);
    }

    @Test
    void checkUnitDiedEvent() {
        final Boolean[] flag = {false};
        Unit john = new Unit(100);
        john.getEvents().subscribe(EventType.UNIT_DIED, new Event(
                null,
                params -> flag[0] = true
        ));
        john.takeDamage(100);
        Assertions.assertTrue(flag[0]);
    }
}

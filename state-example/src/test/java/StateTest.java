import entity.AudioPlayer;
import entity.State;
import entity.UserInterface;
import entity.states.LockedState;
import entity.states.PlayingState;
import entity.states.ReadyState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class StateTest {
    private static UserInterface ui;

    @BeforeEach
    public void before() {
        ui = new UserInterface(new AudioPlayer());
    }

    @ParameterizedTest
    @MethodSource("checkStateData")
    void checkState(List<Method> methodList, Class<? extends State> expected)
            throws InvocationTargetException, IllegalAccessException {
        if (methodList != null) {
            for (Method method : methodList) {
                if (method == null) continue;
                method.invoke(ui);
            }
        }
        Assertions.assertEquals(expected, ui.getPlayer().getState().getClass());
    }

    public static Stream<Arguments> checkStateData() throws NoSuchMethodException {
        return Stream.of(
                Arguments.arguments(
                        Collections.singletonList(UserInterface.class.getMethod("clickPlay")), PlayingState.class),
                Arguments.arguments(
                        Collections.singletonList(UserInterface.class.getMethod("clickLock")), LockedState.class),
                Arguments.arguments(
                        Arrays.asList(
                                UserInterface.class.getMethod("clickPlay"),
                                UserInterface.class.getMethod("clickPlay")),
                        ReadyState.class),
                Arguments.arguments(
                        Arrays.asList(
                                UserInterface.class.getMethod("clickLock"),
                                UserInterface.class.getMethod("clickLock")),
                        ReadyState.class),
                Arguments.arguments(
                        Arrays.asList(
                                UserInterface.class.getMethod("clickPlay"),
                                UserInterface.class.getMethod("clickLock")),
                        LockedState.class),
                Arguments.arguments(
                        Arrays.asList(
                                UserInterface.class.getMethod("clickLock"),
                                UserInterface.class.getMethod("clickPlay")),
                        LockedState.class),
                Arguments.arguments(
                        Arrays.asList(
                                UserInterface.class.getMethod("clickPlay"),
                                UserInterface.class.getMethod("clickLock"),
                                UserInterface.class.getMethod("clickLock")),
                        ReadyState.class),
                Arguments.arguments(
                        Arrays.asList(
                                UserInterface.class.getMethod("clickLock"),
                                UserInterface.class.getMethod("clickLock"),
                                UserInterface.class.getMethod("clickPlay")),
                        PlayingState.class),
                Arguments.arguments(Arrays.asList(null, null, null), ReadyState.class),
                Arguments.arguments(null, ReadyState.class)
        );
    }
}

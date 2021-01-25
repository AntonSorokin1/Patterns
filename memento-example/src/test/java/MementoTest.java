import api.UnitCommand;
import api.commands.MoveDownUnitCommand;
import api.commands.MoveLeftUnitCommand;
import api.commands.MoveRightUnitCommand;
import api.commands.MoveUpUnitCommand;
import entity.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Stream;

class MementoTest {
    private static Unit unit;

    @BeforeEach
    public void before() {
        unit = new Unit(0, 0);
    }

    @ParameterizedTest
    @MethodSource("checkCommandsExecuteData")
    void checkCommandsExecute(List<Class<UnitCommand>> commands, Integer expectedX, Integer expectedY)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        if (commands != null) {
            for (Class<UnitCommand> commandClass : commands) {
                if (commandClass == null) continue;
                UnitCommand command = commandClass.getConstructor(Unit.class).newInstance(unit);
                command.execute();
            }
        }
        Assertions.assertTrue(unit.getX().equals(expectedX) && unit.getY().equals(expectedY));
    }

    @ParameterizedTest
    @MethodSource("checkCommandsExecuteData")
    void checkCommandsMultipleExecute(List<Class<UnitCommand>> commands, Integer expectedX, Integer expectedY)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        if (commands != null) {
            for (Class<UnitCommand> commandClass : commands) {
                if (commandClass == null) continue;
                UnitCommand command = commandClass.getConstructor(Unit.class).newInstance(unit);
                command.execute();
                command.execute();
                command.execute();
            }
        }
        Assertions.assertTrue(unit.getX().equals(expectedX) && unit.getY().equals(expectedY));
    }

    @ParameterizedTest
    @MethodSource("checkCommandsExecuteAndUndoData")
    void checkCommandsExecuteAndUndo(List<Class<UnitCommand>> commands)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        if (commands != null) {
            Deque<UnitCommand> commandDeque = new ArrayDeque<>();
            for (Class<UnitCommand> commandClass : commands) {
                if (commandClass == null) continue;
                UnitCommand command = commandClass.getConstructor(Unit.class).newInstance(unit);
                commandDeque.addFirst(command);
                command.execute();
            }
            commandDeque.forEach(UnitCommand::undo);
        }
        Assertions.assertTrue(unit.getX().equals(0) && unit.getY().equals(0));
    }

    @ParameterizedTest
    @MethodSource("checkCommandsExecuteAndUndoData")
    void checkCommandsExecuteAndMultipleUndo(List<Class<UnitCommand>> commands)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        if (commands != null) {
            Deque<UnitCommand> commandDeque = new ArrayDeque<>();
            for (Class<UnitCommand> commandClass : commands) {
                if (commandClass == null) continue;
                UnitCommand command = commandClass.getConstructor(Unit.class).newInstance(unit);
                commandDeque.addFirst(command);
                command.execute();
            }
            commandDeque.forEach(UnitCommand::undo);
            commandDeque.forEach(UnitCommand::undo);
            commandDeque.forEach(UnitCommand::undo);
        }
        Assertions.assertTrue(unit.getX().equals(0) && unit.getY().equals(0));
    }

    public static Stream<Arguments> checkCommandsExecuteData() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(MoveRightUnitCommand.class, MoveRightUnitCommand.class), 2, 0),
                Arguments.arguments(Arrays.asList(MoveLeftUnitCommand.class, MoveLeftUnitCommand.class), -2, 0),
                Arguments.arguments(Arrays.asList(MoveUpUnitCommand.class, MoveUpUnitCommand.class), 0, -2),
                Arguments.arguments(Arrays.asList(MoveDownUnitCommand.class, MoveDownUnitCommand.class), 0, 2),
                Arguments.arguments(Arrays.asList(MoveRightUnitCommand.class, MoveLeftUnitCommand.class), 0, 0),
                Arguments.arguments(Arrays.asList(MoveUpUnitCommand.class, MoveDownUnitCommand.class), 0, 0),
                Arguments.arguments(
                        Arrays.asList(
                                MoveRightUnitCommand.class, MoveLeftUnitCommand.class,
                                MoveUpUnitCommand.class, MoveDownUnitCommand.class
                        ), 0, 0
                ),
                Arguments.arguments(Arrays.asList(null, null, null), 0, 0),
                Arguments.arguments(null, 0, 0)
        );
    }

    public static Stream<List<Class<? extends UnitCommand>>> checkCommandsExecuteAndUndoData() {
        return Stream.of(
                Arrays.asList(MoveRightUnitCommand.class, MoveRightUnitCommand.class),
                Arrays.asList(MoveLeftUnitCommand.class, MoveLeftUnitCommand.class),
                Arrays.asList(MoveUpUnitCommand.class, MoveUpUnitCommand.class),
                Arrays.asList(MoveDownUnitCommand.class, MoveDownUnitCommand.class),
                Arrays.asList(MoveRightUnitCommand.class, MoveLeftUnitCommand.class),
                Arrays.asList(MoveUpUnitCommand.class, MoveDownUnitCommand.class),
                Arrays.asList(MoveRightUnitCommand.class, MoveLeftUnitCommand.class, MoveUpUnitCommand.class, MoveDownUnitCommand.class),
                Arrays.asList(null, null, null),
                null
        );
    }
}

import api.Command;
import api.commands.MoveDownCommand;
import api.commands.MoveLeftCommand;
import api.commands.MoveRightCommand;
import api.commands.MoveUpCommand;
import entity.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class CommandTest {
    @ParameterizedTest
    @MethodSource("checkExecuteCommandsData")
    void checkExecuteCommands(List<Class<? extends Command>> commands, int unitX, int unitY, int expectedX, int expectedY)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Unit unit = new Unit(unitX, unitY);
        for (Class<? extends Command> command : commands) {
            Command temp = command.getConstructor(Unit.class).newInstance(unit);
            temp.execute();
        }
        Assertions.assertTrue(unit.getX() == expectedX && unit.getY() == expectedY);
    }

    @ParameterizedTest
    @MethodSource("checkExecuteCommandsData")
    void checkMultipleExecuteCommands(List<Class<? extends Command>> commands, int unitX, int unitY, int expectedX, int expectedY)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Unit unit = new Unit(unitX, unitY);
        for (Class<? extends Command> command : commands) {
            Command temp = command.getConstructor(Unit.class).newInstance(unit);
            temp.execute();
            temp.execute();
            temp.execute();
        }
        Assertions.assertTrue(unit.getX() == expectedX && unit.getY() == expectedY);
    }

    @ParameterizedTest
    @MethodSource("checkUndoCommandsData")
    void checkUndoCommands(List<Class<? extends Command>> commands, int unitX, int unitY, int expectedX, int expectedY)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Unit unit = new Unit(unitX, unitY);
        for (Class<? extends Command> command : commands) {
            Command temp = command.getConstructor(Unit.class).newInstance(unit);
            temp.execute();
            temp.undo();
        }
        Assertions.assertTrue(unit.getX() == expectedX && unit.getY() == expectedY);
    }

    @ParameterizedTest
    @MethodSource("checkUndoCommandsData")
    void checkMultipleUndoCommands(List<Class<? extends Command>> commands, int unitX, int unitY, int expectedX, int expectedY)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Unit unit = new Unit(unitX, unitY);
        for (Class<? extends Command> command : commands) {
            Command temp = command.getConstructor(Unit.class).newInstance(unit);
            temp.execute();
            temp.undo();
            temp.undo();
            temp.undo();
        }
        Assertions.assertTrue(unit.getX() == expectedX && unit.getY() == expectedY);
    }

    @ParameterizedTest
    @MethodSource("checkUndoCommandsData")
    void checkUndoWithoutExecuteCommands(List<Class<? extends Command>> commands, int unitX, int unitY, int expectedX, int expectedY)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Unit unit = new Unit(unitX, unitY);
        for (Class<? extends Command> command : commands) {
            Command temp = command.getConstructor(Unit.class).newInstance(unit);
            temp.undo();
        }
        Assertions.assertTrue(unit.getX() == expectedX && unit.getY() == expectedY);
    }

    public static Stream<Arguments> checkExecuteCommandsData() {
        return Stream.of(
                Arguments.arguments(Collections.singletonList(MoveRightCommand.class), 0, 0, 1, 0),
                Arguments.arguments(Collections.singletonList(MoveLeftCommand.class), 0, 0, -1, 0),
                Arguments.arguments(Collections.singletonList(MoveUpCommand.class), 0, 0, 0, -1),
                Arguments.arguments(Collections.singletonList(MoveDownCommand.class), 0, 0, 0, 1)
        );
    }

    public static Stream<Arguments> checkUndoCommandsData() {
        return Stream.of(
                Arguments.arguments(Collections.singletonList(MoveRightCommand.class), 0, 0, 0, 0),
                Arguments.arguments(Collections.singletonList(MoveLeftCommand.class), 0, 0, 0, 0),
                Arguments.arguments(Collections.singletonList(MoveUpCommand.class), 0, 0, 0, 0),
                Arguments.arguments(Collections.singletonList(MoveDownCommand.class), 0, 0, 0, 0)
        );
    }
}

package api;

public interface Command {
    void execute();

    void undo();
}

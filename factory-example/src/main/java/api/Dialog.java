package api;

import entity.Button;

import java.util.ArrayList;
import java.util.List;

public abstract class Dialog {
    private final List<Button> buttons = new ArrayList<>();

    public abstract void createButton();

    protected void addButton(Button button) {
        buttons.add(button);
    }

    public Button getButton(Integer index) {
        return buttons.get(index);
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        buttons.forEach(button -> sb.append(button.render()).append('\n'));
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}

package entity.impl;

import entity.Component;
import entity.Mediator;

public class Dialog implements Mediator {
    private final Button okButton;
    private final Button cleanButton;
    private final TextFrame textFrame;

    public Dialog() {
        this.okButton = new Button(this);
        this.cleanButton = new Button(this);
        this.textFrame = new TextFrame(this);
    }

    public Button getOkButton() {
        return okButton;
    }

    public Button getCleanButton() {
        return cleanButton;
    }

    public TextFrame getTextFrame() {
        return textFrame;
    }

    @Override
    public void notify(Component component) {
        if (okButton.equals(component)) {
            textFrame.setText("Ok!");
        }
        else if (cleanButton.equals(component)) {
            textFrame.setText("");
        }
    }
}

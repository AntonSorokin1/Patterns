package entity.impl;

import entity.Component;
import entity.Mediator;

public class TextFrame extends Component {
    private String text;

    public TextFrame(Mediator mediator) {
        super(mediator);
        this.text = "";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

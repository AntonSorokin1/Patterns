package api.impl;

import api.Dialog;
import entity.impl.WebButton;

public class WebDialog extends Dialog {
    @Override
    public void createButton() {
        addButton(new WebButton());
    }
}

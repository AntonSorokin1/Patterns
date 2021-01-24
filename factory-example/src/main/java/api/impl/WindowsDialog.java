package api.impl;

import api.Dialog;
import entity.impl.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public void createButton() {
        addButton(new WindowsButton());
    }
}

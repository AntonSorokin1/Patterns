package entity.impl;

import entity.Container;

public class Dialog extends Container {
    private String anotherHelpText;

    public void setAnotherHelpText(String anotherHelpText) {
        this.anotherHelpText = anotherHelpText;
    }

    @Override
    public String getHelp() {
        if (anotherHelpText != null) {
            return anotherHelpText;
        }
        return super.getHelp();
    }
}

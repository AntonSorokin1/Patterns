package entity.impl;

import entity.Button;

public class WindowsButton implements Button {
    @Override
    public String click() {
        return "Windows button was clicked!";
    }

    @Override
    public String render() {
        return "Windows button was rendered!";
    }
}

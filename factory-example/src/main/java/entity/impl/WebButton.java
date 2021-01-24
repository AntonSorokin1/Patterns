package entity.impl;

import entity.Button;

public class WebButton implements Button {
    @Override
    public String click() {
        return "Web button was clicked!";
    }

    @Override
    public String render() {
        return "Web button was rendered!";
    }
}

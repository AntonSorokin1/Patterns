package entity.impl;

import entity.Component;

public class Button extends Component {
    private String someURL;

    public void setSomeURL(String someURL) {
        this.someURL = someURL;
    }

    @Override
    public String getHelp() {
        if (someURL != null) {
            return someURL;
        }
        return super.getHelp();
    }
}

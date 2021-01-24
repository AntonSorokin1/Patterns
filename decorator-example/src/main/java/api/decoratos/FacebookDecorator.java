package api.decoratos;

import api.BaseDecorator;
import api.Notifier;

public class FacebookDecorator extends BaseDecorator {
    public FacebookDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public String notifyMe() {
        return super.notifyMe() + "It's facebook notify!\n";
    }
}

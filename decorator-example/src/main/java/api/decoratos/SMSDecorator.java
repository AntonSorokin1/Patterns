package api.decoratos;

import api.BaseDecorator;
import api.Notifier;

public class SMSDecorator extends BaseDecorator {
    public SMSDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public String notifyMe() {
        return super.notifyMe() + "It's SMS notify!\n";
    }
}

package api.decoratos;

import api.BaseDecorator;
import api.Notifier;

public class VKDecorator extends BaseDecorator {
    public VKDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public String notifyMe() {
        return super.notifyMe() + "It's VK notify!\n";
    }
}

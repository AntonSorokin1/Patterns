package api;

public abstract class BaseDecorator implements Notifier {
    protected Notifier wrappee;

    protected BaseDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String notifyMe() {
        return wrappee.notifyMe();
    }
}

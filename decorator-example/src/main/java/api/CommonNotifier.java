package api;

public class CommonNotifier implements Notifier {
    @Override
    public String notifyMe() {
        return "You was notified!\n";
    }
}

package entity;

public class Remote {
    private static final int DELTA_VOLUME = 10;
    private static final int DELTA_CHANNEL = 1;

    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void switchPower() {
        if (device.isEnable()) {
            device.turnOff();
        } else {
            device.turnOn();
        }
    }

    public void volumeDown() {
        if (!device.isEnable()) return;
        device.setVolume(device.getVolume() - DELTA_VOLUME);
    }

    public void volumeUp() {
        if (!device.isEnable()) return;
        device.setVolume(device.getVolume() + DELTA_VOLUME);
    }

    public void channelDown() {
        if (!device.isEnable()) return;
        device.setChannel(device.getChannel() - DELTA_CHANNEL);
    }

    public void channelUp() {
        if (!device.isEnable()) return;
        device.setChannel(device.getChannel() + DELTA_CHANNEL);
    }
}

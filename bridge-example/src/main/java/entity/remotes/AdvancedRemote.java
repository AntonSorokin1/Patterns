package entity.remotes;

import entity.Device;
import entity.Remote;

public class AdvancedRemote extends Remote {
    private Integer previousVolume;

    public AdvancedRemote(Device device) {
        super(device);
        this.previousVolume = 0;
    }

    public void setVolume(Integer value) {
        if (!device.isEnable()) return;
        device.setVolume(value);
    }

    public void mute() {
        if (!device.isEnable()) return;
        if (device.getVolume() > 0) {
            previousVolume = device.getVolume();
            device.setVolume(0);
        }
        else {
            device.setVolume(previousVolume);
        }
    }
}

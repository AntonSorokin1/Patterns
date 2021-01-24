package entity.devices;

import entity.Device;

public class Tv implements Device {
    private Boolean enable;
    private Integer volume;
    private Integer channel;

    public Tv() {
        this.enable = false;
        this.volume = 0;
        this.channel = 0;
    }

    @Override
    public boolean isEnable() {
        return enable;
    }

    @Override
    public void turnOn() {
        this.enable = true;
    }

    @Override
    public void turnOff() {
        this.enable = false;
    }

    @Override
    public void setVolume(int value) {
        this.volume = value;
    }

    @Override
    public Integer getVolume() {
        return volume;
    }

    @Override
    public void setChannel(Integer value) {
        this.channel = value;
    }

    @Override
    public Integer getChannel() {
        return channel;
    }
}

package entity;

public interface Device {
    boolean isEnable();

    void turnOn();

    void turnOff();

    void setVolume(int value);

    Integer getVolume();

    void setChannel(Integer value);

    Integer getChannel();
}
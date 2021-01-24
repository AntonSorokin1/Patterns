import entity.Device;
import entity.Remote;
import entity.devices.Radio;
import entity.devices.Tv;
import entity.remotes.AdvancedRemote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BridgeTest {
    @ParameterizedTest
    @MethodSource("checkAdvancedRemoteMuteData")
    void checkAdvancedRemoteMute(Device device, Integer currentVolume) {
        AdvancedRemote remote = new AdvancedRemote(device);
        remote.switchPower();
        remote.setVolume(currentVolume);
        remote.mute();
        Assertions.assertEquals(0, device.getVolume());
    }

    @ParameterizedTest
    @MethodSource("checkRemoteChannelData")
    void checkRemoteChannel(Device device, Integer channelSwitch, Integer expected) {
        Remote remote = new Remote(device);
        remote.switchPower();
        for (int i = 0; i < channelSwitch; i++) {
            remote.channelUp();
        }
        Assertions.assertEquals(expected, device.getChannel());
    }

    @ParameterizedTest
    @MethodSource("checkRemoteSoundData")
    void checkRemoteSound(Device device, Integer soundSwitch, Integer expected) {
        Remote remote = new Remote(device);
        remote.switchPower();
        for (int i = 0; i < soundSwitch; i++) {
            remote.volumeUp();
        }
        Assertions.assertEquals(expected, device.getVolume());
    }

    public static Stream<Arguments> checkRemoteChannelData() {
        return Stream.of(
                Arguments.arguments(new Tv(), 2, 2),
                Arguments.arguments(new Tv(), 10, 10),
                Arguments.arguments(new Radio(), 1, 1),
                Arguments.arguments(new Radio(), 0, 0)
        );
    }

    public static Stream<Arguments> checkRemoteSoundData() {
        return Stream.of(
                Arguments.arguments(new Tv(), 2, 20),
                Arguments.arguments(new Tv(), 10, 100),
                Arguments.arguments(new Radio(), 1, 10),
                Arguments.arguments(new Radio(), 0, 0)
        );
    }

    public static Stream<Arguments> checkAdvancedRemoteMuteData() {
        return Stream.of(
                Arguments.arguments(new Tv(), 57),
                Arguments.arguments(new Tv(), 0),
                Arguments.arguments(new Radio(), 1),
                Arguments.arguments(new Radio(), -12)
        );
    }
}

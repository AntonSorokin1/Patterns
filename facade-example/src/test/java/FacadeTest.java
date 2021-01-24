import api.VideoConverterFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import some_complex_library.VideoFile;

import java.util.stream.Stream;

class FacadeTest {
    @ParameterizedTest
    @MethodSource("convertFileData")
    void convertFile(String oldFormat, String newFormat) {
        VideoFile file = new VideoFile("some_video." + oldFormat);
        VideoConverterFacade facade = new VideoConverterFacade();
        facade.convertVideo(file, newFormat);
        Assertions.assertEquals(newFormat, facade.convertVideo(file, newFormat).getCodecType());
    }

    public static Stream<Arguments> convertFileData() {
        return Stream.of(
                Arguments.arguments("mp4", "ogg"),
                Arguments.arguments("ogg", "mp4"),
                Arguments.arguments("mp4", "mp4"),
                Arguments.arguments("ogg", "ogg")
        );
    }
}

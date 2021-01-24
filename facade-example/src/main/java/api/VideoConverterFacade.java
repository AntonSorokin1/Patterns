package api;

import some_complex_library.*;
import some_complex_library.codecs.*;

public class VideoConverterFacade {
    public VideoFile convertVideo(VideoFile file, String newFormat) {
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if ("ogg".equals(newFormat)) {
            destinationCodec = new OggCompressionCodec();
        } else {
            destinationCodec = new MPEG4CompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile preResult = BitrateReader.convert(buffer, destinationCodec);
        return (new AudioMixer()).fix(preResult);
    }
}

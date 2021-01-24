package some_complex_library;

import some_complex_library.codecs.MPEG4CompressionCodec;
import some_complex_library.codecs.OggCompressionCodec;

public class CodecFactory {
    private CodecFactory() {
    }

    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if ("mp4".equals(type)) {
            return new MPEG4CompressionCodec();
        } else {
            return new OggCompressionCodec();
        }
    }
}

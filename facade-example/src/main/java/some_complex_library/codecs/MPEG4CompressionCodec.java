package some_complex_library.codecs;

import some_complex_library.Codec;

public class MPEG4CompressionCodec implements Codec {
    private final String type;

    public MPEG4CompressionCodec() {
        this.type = "mp4";
    }

    @Override
    public String getType() {
        return type;
    }
}

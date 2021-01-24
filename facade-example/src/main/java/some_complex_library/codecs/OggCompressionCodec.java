package some_complex_library.codecs;

import some_complex_library.Codec;

public class OggCompressionCodec implements Codec {
    private final String type;

    public OggCompressionCodec() {
        type = "ogg";
    }

    @Override
    public String getType() {
        return type;
    }
}

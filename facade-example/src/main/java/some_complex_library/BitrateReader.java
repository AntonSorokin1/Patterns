package some_complex_library;

public class BitrateReader {
    private BitrateReader() {
    }

    public static VideoFile read(VideoFile file, Codec codec) {
        codec.getType();
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        String newName = buffer.getName().substring(0, buffer.getName().indexOf('.') + 1) + codec.getType();
        return new VideoFile(newName);
    }
}

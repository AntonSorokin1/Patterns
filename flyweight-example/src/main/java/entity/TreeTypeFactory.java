package entity;

import java.util.ArrayList;
import java.util.List;

public class TreeTypeFactory {
    private static final List<TreeType> types = new ArrayList<>();

    private TreeTypeFactory() {
    }

    public static TreeType getTreeType(String name, String color, String texture) {
        TreeType result = new TreeType(name, color, texture);
        for (TreeType type : types) {
            if (type.getName().equals(name) && type.getColor().equals(color) && type.getTexture().equals(texture)) {
                return type;
            }
        }
        types.add(result);
        return result;
    }
}

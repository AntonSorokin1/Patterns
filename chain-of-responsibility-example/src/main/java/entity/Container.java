package entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Container extends Component {
    protected List<Component> children;

    protected Container() {
        this.children = new ArrayList<>();
    }

    public void addChild(Component child) {
        children.add(child);
        child.setContainer(this);
    }
}

package entity;

public class Component {
    private final Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    public void click() {
        mediator.notify(this);
    }
}

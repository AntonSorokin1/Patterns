package entity;

public abstract class Component implements ComponentWithHelp {
    protected String help;
    protected Container container;

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public String getHelp() {
        return (help != null) ? help : container.getHelp();
    }

    public void setHelp(String help) {
        this.help = help;
    }
}

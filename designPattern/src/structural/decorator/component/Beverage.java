package structural.decorator.component;

public abstract class Beverage {
    protected static int TALL = 1;
    protected static int GRANDE = 2;
    protected static int VENTI = 3;

    protected String description = "Unknown Beverage";

    protected int size;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

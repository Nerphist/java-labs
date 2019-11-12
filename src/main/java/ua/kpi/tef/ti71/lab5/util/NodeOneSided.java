package ua.kpi.tef.ti71.lab5.util;

public class NodeOneSided<T> {
    private NodeOneSided<T> previous;
    private T value;

    public NodeOneSided() {
    }

    public NodeOneSided(NodeOneSided<T> previous, T value) {
        setPrevious(previous);
        this.value = value;
    }

    public NodeOneSided(T value) {
        this(null, value);
    }

    public NodeOneSided<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeOneSided<T> previous) {
        this.previous = previous;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
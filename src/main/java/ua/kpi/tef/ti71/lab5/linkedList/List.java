package ua.kpi.tef.ti71.lab5.linkedList;


public interface List<T> {
    void add(T element);

    void add(int index, T element);

    void set(int index, T element);

    T get(int index);

    void remove(int index);

    boolean contains(T element);

    boolean isEmpty();

    int size();

    void clear();

}

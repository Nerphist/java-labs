package ua.kpi.tef.ti71.lab6.utils;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

public class ObservableList<T> {

    protected final List<T> list;
    private final PublishSubject<T> onAdd;

    public ObservableList() {
        this.list = new ArrayList<T>();
        this.onAdd = PublishSubject.create();
    }

    public void add(T value) {
        list.add(value);
        onAdd.onNext(value);
    }

    public Observable<T> getObservable() {
        return onAdd;
    }
}


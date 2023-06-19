package Model;

import ViewController.iObserver;
import ViewController.iPublisher;

import java.util.HashSet;
import java.util.Set;

public class UseData implements iPublisher {
    Data data;

    private Set<iObserver> observers = new HashSet<>();

    @Override
    public void registerObserver(iObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(iObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (iObserver observer : observers)
            observer.update(data);
    }

    public Data getData() {
        return data;
    }

    public void onNewData(Data newData) {
        this.data = newData;
        notifyObservers();
    }
}

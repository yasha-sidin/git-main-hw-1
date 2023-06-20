package Model;

import ViewController.iGetModel;
import ViewController.iPublisher;

import java.util.HashSet;
import java.util.Set;

public class UseData implements iPublisher {
    Data data;

    private Set<iGetModel> observers = new HashSet<>();

    @Override
    public void registerObserver(iGetModel observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(iGetModel observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (iGetModel observer : observers)
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

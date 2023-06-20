package ViewController;

import Model.Data;

public interface iPublisher {

    public void registerObserver(iGetModel observer);

    public void unregisterObserver(iGetModel observer);

    public void notifyObservers();

    public void onNewData(Data data);
}

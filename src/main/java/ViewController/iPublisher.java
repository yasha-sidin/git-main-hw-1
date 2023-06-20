package ViewController;

public interface iPublisher {

    public void registerObserver(iObserver observer);

    public void unregisterObserver(iObserver observer);

    public void notifyObservers();

    public void onNewData(Data data);
}

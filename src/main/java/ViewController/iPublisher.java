package ViewController;

import Model.Data;

public interface iPublisher {

    /**
     * Register new observer
     * @param observer new observer of iPublisher
     */
    public void registerObserver(iGetModel observer);

    /**
     *
     * @param observer current observer of iPublisher
     */
    public void unregisterObserver(iGetModel observer);

    /**
     * Notify all Observers about new data
     */
    public void notifyObservers();

    /**
     * Update data in iPublisher
     * @param data new data which will be published to observers
     */
    public void onNewData(Data data);
}

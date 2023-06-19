public interface iPublisher {
  
  public void registerObserver();
  
  public void unregisterObserver();
  
  public void notifyObserver();
}

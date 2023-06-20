package ViewController;
import Model.Data;

public interface iObserver {

  /**
   * Parse info from iPublisher
   * @param data info from iPublisher which must be parsed
   */
  public void update(Data data);
}

public class LogToConsole implements iObserver {
  public LogToConsole(iPublisher publisher) {
    publisher.registerObserver(this);
  }

  public void update(Data data) {
     System.out.println(data);
  }
}

public class LogToFile implements iObserver {
  public LogToFile(iPublisher publisher) {
    publisher.registerObserver(this);
  }

  public void update(Data data) {
    try(FileWriter fw = new FileWriter("CalculateLogs", true){
        fw.write(data + "\n");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
  }
}

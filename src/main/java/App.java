import Model.LogToFile;
import Model.LogToList;
import Model.UseData;
import ViewController.ViewController;
import ViewController.iGetModel;
import ViewController.iPublisher;

public class App {
    public static void main(String[] args) throws Exception {
        iPublisher logsPublisher = new UseData();
        iGetModel firstFileLog = new LogToFile(logsPublisher, "FirstLogsFile.txt");
        iGetModel secondFileLog = new LogToFile(logsPublisher, "SecondLogsFile.txt");
        iGetModel listOfLogs = new LogToList(logsPublisher);
        
        ViewController program = new ViewController();
        
        program.initialize(logsPublisher);
    }
}

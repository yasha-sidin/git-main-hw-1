package Model;

import ViewController.iGetModel;
import ViewController.iObserver;
import ViewController.iPublisher;

import java.text.SimpleDateFormat;
import java.util.List;

public class LogToList implements iGetModel {
    private List<String> logList;

    public LogToList(iPublisher publisher) {
        publisher.registerObserver(this);
    }

    @Override
    public void update(Data data) {
        logList.add(new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a zzz").toString() + " : " + data.toString());
    }

    @Override
    public List getLogs() {
        return logList;
    }
}

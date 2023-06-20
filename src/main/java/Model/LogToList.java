package Model;

import ViewController.iGetModel;
import ViewController.iObserver;
import ViewController.iPublisher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogToList implements iGetModel {
    private List<String> logList = new ArrayList<>();

    /**
     * Constructor of LogToFile
     * @param publisher iPublisher which LogToList will observe
     */
    public LogToList(iPublisher publisher) {

        publisher.registerObserver(this);
    }

    @Override
    public void update(Data data) {
        Date currentDate = new Date(System.currentTimeMillis());
        logList.add(currentDate + " : " + data.toString());
    }

    @Override
    public List getLogs() {
        return logList;
    }
}

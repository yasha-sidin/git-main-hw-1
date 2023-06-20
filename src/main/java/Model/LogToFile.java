package Model;

import ViewController.iGetModel;
import ViewController.iObserver;
import ViewController.iPublisher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogToFile implements iGetModel {
    String fileName;

    /**
     * Constructor of LogToFile
     * @param publisher iPublisher which LogToFile will observe
     * @param fileName  name of new file which will observe logs
     */
    public LogToFile(iPublisher publisher, String fileName) {
        publisher.registerObserver(this);
        this.fileName = fileName;
    }

    @Override
    public void update(Data data) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            Date currentDate = new Date(System.currentTimeMillis());
            fw.write(currentDate + " : " + data.getData() + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List getLogs() {
        List logList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                logList.add(line);
                line = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return logList;
    }
}

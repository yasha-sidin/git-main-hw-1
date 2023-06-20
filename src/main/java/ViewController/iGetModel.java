package ViewController;

import java.util.List;

public interface iGetModel extends iObserver{

    /**
     *
     * @return current List of Logs
     */
    public List getLogs();
}

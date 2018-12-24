package com.example.chevasso.ihm_app;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton to transfer data between activiyies
 */
public class DataManager {

    // Singleton logic

    private static DataManager instance;

    private DataManager() {
        init();
    }

    public static DataManager getInstance() {
        if (instance == null)
        {
            instance = new DataManager();
        }
        return instance;
    }

    // Data storing

    private List<String> nameList;

    private void init() {
        nameList = new ArrayList<String>();
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void addName(String name) {
        this.nameList.add(name);
    }

}

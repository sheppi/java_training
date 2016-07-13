package com.epam.pool.controller;

import java.util.ResourceBundle;

/**
 * Created by Kirill_Kaluga on 7/13/2016.
 */
public class DBResourceManager {
    private static DBResourceManager uniqueInstance;

    private ResourceBundle bundle = ResourceBundle.getBundle("_java._se._07._connectionpool.dc");

    private DBResourceManager(){

    }

    public static DBResourceManager getInstance(){
        if (uniqueInstance == null) {
            uniqueInstance = new DBResourceManager();
        }
        return uniqueInstance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }

}

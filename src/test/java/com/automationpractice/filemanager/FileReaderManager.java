package com.automationpractice.filemanager;

import com.automationpractice.utils.ConfigFileReader;

public class FileReaderManager {

    /**
     * This Class and methods is used to read Config files
     * */

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    private FileReaderManager(){}

    public static FileReaderManager getInstance(){
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader(){
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}

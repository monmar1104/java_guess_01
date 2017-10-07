package com.isa.homeworks;

import java.io.InputStream;
import java.util.Scanner;

public class FileReader {

    private String pathName;
    Scanner scanner;
    FileReader(String pathName) {
        this.pathName = pathName;
        InputStream activitiesStream = App.class.getClassLoader().getResourceAsStream(pathName);
        this.scanner = new Scanner(activitiesStream).useDelimiter("\n");
    }




    public Scanner getScanner() {
        return scanner;
    }
}

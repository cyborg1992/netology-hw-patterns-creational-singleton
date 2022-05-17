package ru.netology;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger;
    private int num = 1;

    private Logger() {}

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        String dateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        System.out.println("[" + dateTime + " " + num++ + "] " + msg);
    }
}

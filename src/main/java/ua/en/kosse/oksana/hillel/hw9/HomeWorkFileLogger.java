package ua.en.kosse.oksana.hillel.hw9;

import ua.en.kosse.oksana.hillel.hw9.exceptions.FileMaxSizeReachedException;

import java.io.File;
import java.io.IOException;

public class HomeWorkFileLogger {

    public static void main(String[] args) throws IOException, FileMaxSizeReachedException {

        FileLogger fileLogger = new FileLogger(FileLoggerConfigurationLoader.
                load(new File("config.txt")));

        for(int i=1; i<=10; i++){
            fileLogger.info("info"+i);
            fileLogger.debug("debug"+i);
        }
    }

}


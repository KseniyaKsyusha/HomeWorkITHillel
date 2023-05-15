package ua.en.kosse.oksana.hillel.hw9;

import ua.en.kosse.oksana.hillel.hw9.exceptions.FileMaxSizeReachedException;
import ua.en.kosse.oksana.hillel.hw9.myenum.LoggingLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private FileLoggerConfiguration fileLogConf;
    private BufferedWriter writer;
    private FileWriter fileLogWriter;


    public FileLogger(FileLoggerConfiguration newFileLogConf) throws IOException {
        fileLogConf = newFileLogConf;
        fileLogWriter = new FileWriter(fileLogConf.getFile());
    }

    public void debug(String message) throws FileMaxSizeReachedException, IOException {
        if (fileLogConf.getLevel() == LoggingLevel.DEBUG) {
            checkFileSize();
            writer = new BufferedWriter(fileLogWriter);
            writeToFile(String.format(fileLogConf.getWriteFormat(), LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LoggingLevel.DEBUG, message));
        }
    }

    public void info(String message) throws IOException {
        checkFileSize();
        writer = new BufferedWriter(fileLogWriter);
        writeToFile(String.format(fileLogConf.getWriteFormat(), LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LoggingLevel.INFO, message));
    }

    public void writeToFile(String logMessage) throws IOException {
        writer.write(logMessage);
        writer.newLine();
        writer.flush();
    }

    private void checkFileSize() throws IOException {
        if (fileLogConf.getFile().length() > fileLogConf.getMaxSizeFile()) {
            File newFile = new File(String.format("./Log_%s.txt", LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy_MM_dd HH-mm-ss.SSS"))));
            fileLogConf.setFile(newFile);
            fileLogWriter = new FileWriter(newFile);
        }
    }
}

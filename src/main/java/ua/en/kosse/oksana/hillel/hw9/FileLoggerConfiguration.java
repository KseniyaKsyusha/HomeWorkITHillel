package ua.en.kosse.oksana.hillel.hw9;

import ua.en.kosse.oksana.hillel.hw9.myenum.LoggingLevel;

import java.io.File;

public class FileLoggerConfiguration {

    private File file;
    private LoggingLevel level;
    private byte maxSizeFile = 127;
    private String writeFormat;

    public FileLoggerConfiguration() {
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public byte getMaxSizeFile() {
        return maxSizeFile;
    }

    public void setMaxSizeFile(byte maxSizeFile) {
        this.maxSizeFile = maxSizeFile;
    }

    public String getWriteFormat() {
        return writeFormat;
    }

    public void setWriteFormat(String writeFormat) {
        this.writeFormat = writeFormat;
    }

}

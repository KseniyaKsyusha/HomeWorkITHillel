package ua.en.kosse.oksana.hillel.hw9;

import ua.en.kosse.oksana.hillel.hw9.myenum.ConfigParams;
import ua.en.kosse.oksana.hillel.hw9.myenum.LoggingLevel;

import java.io.*;

public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load(File file) throws IOException {
        FileLoggerConfiguration loadFileLogConfig = new FileLoggerConfiguration();
        BufferedReader bufRead = new BufferedReader(new FileReader(file));
        String line;

        while ((line = bufRead.readLine()) != null) {
            if (line.contains(ConfigParams.FILE.name())) {
                loadFileLogConfig.setFile(new File(line.split(": ")[1]));

            } else if (line.contains(ConfigParams.MAX_SIZE.name())) {
                loadFileLogConfig.setMaxSizeFile(Byte.valueOf(line.split(": ")[1]));

            } else if (line.contains(ConfigParams.LEVEL.name())) {
                loadFileLogConfig.setLevel(LoggingLevel.valueOf(line.split(": ")[1]));

            } else if (line.contains(ConfigParams.FORMAT.name())) {
                loadFileLogConfig.setWriteFormat(line.split(": ")[1]);
            }
        }



        return loadFileLogConfig;
    }
}
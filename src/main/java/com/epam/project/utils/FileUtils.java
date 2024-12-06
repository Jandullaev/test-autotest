package com.epam.project.utils;

import java.nio.file.FileSystems;

import static java.lang.String.format;

public class FileUtils {

    public static final String FILE_DELIMITER = FileSystems.getDefault().getSeparator();
    public static String getDownloadedFilePath() {
        String[] pathNames = {"src", "test", "downloads"};
        String pathSecondPart = String.join(FILE_DELIMITER, pathNames);
        return format("%s%s%s", System.getProperty("user.dir"),FILE_DELIMITER, pathSecondPart);
    }
}

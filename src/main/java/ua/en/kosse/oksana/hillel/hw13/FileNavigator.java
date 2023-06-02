package ua.en.kosse.oksana.hillel.hw13;

import java.util.*;

public class FileNavigator {
    Map<String, ArrayList<FileData>> fileMap = new HashMap<>();

    public void add(String filePath, FileData fileName) {
        if (!filePath.equals(fileName.getPathFile())) {
            System.out.println("The path does not match the specified path in the file");}
        else if (fileMap.containsKey(filePath)) {
            fileMap.get(filePath).add(fileName);
        } else {
            ArrayList<FileData> dataFile = new ArrayList<>();
            dataFile.add(fileName);
            fileMap.put(filePath, dataFile);
        }
    }

    public ArrayList<FileData> find(String filePath) {
        return fileMap.get(filePath);
    }

    public ArrayList<FileData> filterBySize(int sizeFileByte) {
        ArrayList<FileData> result = new ArrayList<>();

        for (ArrayList<FileData> myFileValue : fileMap.values()) {
            for (FileData fileValue : myFileValue) {
                if (fileValue.getSizeFileByte() <= sizeFileByte) {
                    result.add(fileValue);
                }
            }
        }
        return result;
    }

    public void remove(String pathFile) {
        fileMap.remove(pathFile);
    }

    public ArrayList<FileData> sortBySize() {
        ArrayList<FileData> sortSize = new ArrayList<>();

        for (ArrayList<FileData> myFileSize : fileMap.values()) {
            for (FileData fileSize : myFileSize) {
                sortSize.add(fileSize);
            }
        }
        Collections.sort(sortSize);
        return sortSize;
    }

    @Override
    public String toString() {
        return "\n\t FileNavigator{" +
                "fileMap=" + fileMap +
                '}';

    }
}




package ua.en.kosse.oksana.hillel.hw13;

public class FileData implements Comparable<FileData> {

    String pathFile;
    String nameFile;
    int sizeFileByte;

    public FileData(String filePath, String fileName, int fileSizeByte) {
        this.pathFile = filePath;
        this.nameFile = fileName;
        this.sizeFileByte = fileSizeByte;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public int getSizeFileByte() {
        return sizeFileByte;
    }

    public void setSizeFileByte(int sizeFileByte) {
        this.sizeFileByte = sizeFileByte;
    }

    @Override
    public String toString() {
        return "\n\t FileData{" +
                "filePath='" + pathFile + '\'' +
                ", fileName='" + nameFile + '\'' +
                ", fileSize=" + sizeFileByte +
                '}';
    }

    @Override
    public int compareTo(FileData fileNew) {
        return this.getSizeFileByte() - fileNew.getSizeFileByte();

    }
}

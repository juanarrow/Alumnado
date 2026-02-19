package files;

import java.util.List;

public interface IFileService<T> {
    public List<T> readFromFile();
    public boolean writeToFile(T[] items, boolean append);
}

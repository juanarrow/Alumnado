package files;

import java.util.List;

import serializable.ISerializable;

public interface IFileService<T extends ISerializable> {
    public List<ISerializable> readFromFile();
    public boolean writeToFile(ISerializable[] items, boolean append);
}
 
package students;

import serializable.ISerializable;
import students.exceptions.ItemAlreadyExists;
import students.exceptions.ItemNotFound;

public interface ICRUD<T extends ISerializable> {
    public ISerializable create(ISerializable item) throws ItemAlreadyExists;
    public Object[] requestAll();
    public ISerializable requestById(int id);
    public ISerializable update(ISerializable item)throws ItemNotFound;
    public ISerializable delete(int id) throws ItemNotFound;
}

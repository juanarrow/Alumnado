package students;

import serializable.ISerializable;
import students.exceptions.ForeignKeyNotFound;
import students.exceptions.ItemAlreadyExists;
import students.exceptions.ItemNotFound;

public interface ICRUD<T extends ISerializable> {
    public ISerializable create(ISerializable item) throws ItemAlreadyExists, ForeignKeyNotFound;
    public ISerializable[] requestAll();
    public ISerializable requestById(Long id);
    public ISerializable update(ISerializable item)throws ItemNotFound;
    public ISerializable delete(Long id) throws ItemNotFound;
} 

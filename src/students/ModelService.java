package students;

import java.util.ArrayList;

import files.FileService;
import serializable.ISerializable;

public class ModelService<T extends ISerializable> implements ICRUD<T>{

    FileService<T> fileService;
    ArrayList<T> items = new ArrayList<>();

    ModelService(String fileName, FileService<T> fileService){        
        this.fileService = fileService;
    }

    @Override
    public T create(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public T[] requestAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestAll'");
    }

    @Override
    public T requestById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestById'");
    }

    @Override
    public T update(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public T delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
}

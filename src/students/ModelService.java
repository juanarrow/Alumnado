package students;

import java.util.ArrayList;

import files.FileService;
import serializable.ISerializable;
import students.exceptions.ItemAlreadyExists;
import students.exceptions.ItemNotFound;

public class ModelService<T extends ISerializable> implements ICRUD<T>{

    FileService<T> fileService;
    ArrayList<ISerializable> items = new ArrayList<>();

    ModelService(FileService<T> fileService){        
        this.fileService = fileService;
        this.items = (ArrayList<ISerializable>) fileService.readFromFile();
    }

    @Override
    public ISerializable create(ISerializable item) throws ItemAlreadyExists {
        if(!this.items.contains(item)){
            this.items.add(item);
            fileService.writeToFile(this.items.toArray(new ISerializable[0]), false);
            return item;
        }
        throw new ItemAlreadyExists(); 
    }
    
    @Override
    public ISerializable[] requestAll() {
        return this.items.toArray(new ISerializable[0]);
    }

    @Override
    public ISerializable requestById(int id) {        
        return this.items
            .stream()
            .filter(item -> item.getId()!=null?item.getId().equals(Long.valueOf(id)):false)
            .findFirst()
            .orElse(null);
    }

    @Override
    public ISerializable update(ISerializable item) throws ItemNotFound {
        if(this.items.contains(item)){
            this.items.set(this.items.indexOf(item), item);
            fileService.writeToFile(this.items.toArray(new ISerializable[0]), false);
            return item;
        }
        throw new ItemNotFound(); 
    }

    @Override
    public ISerializable delete(int id) throws ItemNotFound{
        ISerializable item = requestById(id);
        if(item != null){
            this.items.remove(item);
            fileService.writeToFile(this.items.toArray(new ISerializable[0]), false);
            return item;
        }
        throw new ItemNotFound(); 
    }

    
}

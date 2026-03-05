package students;

import java.util.ArrayList;

import files.FileService;
import serializable.ISerializable;
import students.exceptions.ForeignKeyNotFound;
import students.exceptions.ItemAlreadyExists;
import students.exceptions.ItemNotFound;

public class ModelService<T extends ISerializable> implements ICRUD<T>{
    Long nextId = 1L;
    FileService<T> fileService;
    ArrayList<ISerializable> items = new ArrayList<>();

    ModelService(FileService<T> fileService){        
        this.fileService = fileService;
        this.items = (ArrayList<ISerializable>) fileService.readFromFile();
        nextId = this.items.get(this.items.size()-1).getId()+1;
    }

    @Override
    public ISerializable create(ISerializable item) throws ItemAlreadyExists, ForeignKeyNotFound {
        if(!this.items.contains(item)){
            this.items.add(item);
            fileService.writeToFile(this.items.toArray(new ISerializable[0]), false);
            nextId = item.getId()+1;
            return item;
        }
        throw new ItemAlreadyExists("Ya existe un item con id "+item.getId()); 
    }
    
    @Override
    public ISerializable[] requestAll() {
        return this.items.toArray(new ISerializable[0]);
    }

    @Override
    public ISerializable requestById(Long id) {        
        return this.items
            .stream()
            .filter(item -> item!=null && item.getId()!=null?item.getId().equals(Long.valueOf(id)):false)
            .findFirst()
            .orElse(null);
    } 

    @Override
    public ISerializable update(ISerializable item) throws ItemNotFound {
        if(this.items.contains(item)){
            int index = this.items.indexOf(item);
            ISerializable prev = this.items.get(index);
            this.items.set(index, item);
            fileService.writeToFile(this.items.toArray(new ISerializable[0]), false);
            return prev;
        } 
        throw new ItemNotFound("No existe un item con id "+item.getId()); 
    }

    @Override
    public ISerializable delete(Long id) throws ItemNotFound{
        ISerializable item = requestById(id);
        if(item != null){
            this.items.remove(item);
            fileService.writeToFile(this.items.toArray(new ISerializable[0]), false);
            return item;
        }
        throw new ItemNotFound("No existe un item con id "+id); 
    }
    
    public Long getNextId() {
        return nextId;
    }
    
}

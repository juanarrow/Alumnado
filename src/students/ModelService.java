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

    @SuppressWarnings("unchecked")
    @Override
    public ISerializable create(ISerializable item) throws ItemAlreadyExists {
        if(!this.items.contains(item)){
            this.items.add(item);
            fileService.writeToFile(this.items.toArray((T[]) new ISerializable[this.items.size()]), false);
            return item;
        }
        throw new ItemAlreadyExists(); 
    }
    
    @Override
    public Object[] requestAll() {
        Object[] objects = this.items.toArray();
        return objects;
    }

    @Override
    public ISerializable requestById(int id) {        

        /*
        //Forma patatera
        T object = null;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getId() == id){
                object = items.get(i);
                break;
            }
        }

        return object;
        */
        return this.items.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ISerializable update(ISerializable item) throws ItemNotFound {
        if(this.items.contains(item)){
            this.items.add(item);
            fileService.writeToFile(this.items.toArray((T[]) new ISerializable[this.items.size()]), false);
            return item;
        }
        throw new ItemNotFound(); 
    }

    @SuppressWarnings("unchecked")
    @Override
    public ISerializable delete(int id) throws ItemNotFound{
        ISerializable item = requestById(id);
        if(item != null){
            this.items.remove(item);
            fileService.writeToFile(this.items.toArray((T[]) new ISerializable[this.items.size()]), false);
            return item;
        }
        throw new ItemNotFound(); 
    }

    
}

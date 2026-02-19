package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import serializable.ISerializable;

import java.io.File;

public abstract class FileService<T extends ISerializable> implements IFileService<T> {
    
    String fileName;
    ArrayList<T> items = new ArrayList<T>();
    
    public FileService(String fileName) {        
        this.fileName = fileName;
    }

    @Override
    public List<T> readFromFile() {
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String line = "";
            while((line = br.readLine()) != null){
                items.add(this.deserialize(line));
            }
            br.close();
            return this.items;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }                
    }
    @Override
    public boolean writeToFile(T[] items, boolean append) {
        try{    
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(this.fileName), append));
            for(T item: items){
                bw.write(item.serialize());
            }
            bw.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }


    public abstract T deserialize(String line);
    


    
}

package students;

import java.text.SimpleDateFormat;
import java.util.Date;

import serializable.ISerializable;

public class Student implements ISerializable {
    long id;
    String name;
    String surname;
    Date birthDate;
    long group_id;

    @Override
    public String serialize() {
        return String.format("%d;%s;%s;%s;%d", id, name, surname, birthDate.toString(), group_id);
    }

    @Override
    public Student deserialize(String data) {
        String[] items = data.split(";");
        if(items== null || items.length != 5) return null;
        try{
            id = Long.parseLong(items[0]);
            name = items[1];
            surname = items[2];
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");            
            birthDate = format.parse( items[3]);   
            group_id = Long.parseLong(items[4]);   
            return this;         
        }
        catch(Exception e){
            return null;
        }        
    }
    
}


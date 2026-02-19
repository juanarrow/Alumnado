package students;


import serializable.ISerializable;

public class Group implements ISerializable{

    Long id;
    String name;
    String tutor;
    Long level;

     @Override
    public String serialize() {
        return String.format("%d;%s;%s;%d", id, name, tutor, level);
    }

    @Override
    public Group deserialize(String data) {
        String[] items = data.split(";");
        if(items== null || items.length != 4) return null;
        try{
            id = Long.parseLong(items[0]);
            name = items[1];
            tutor = items[2];
            level = Long.parseLong(items[3]);   
            return this;         
        }
        catch(Exception e){
            return null;
        }        
    }
    
    
}

package students;


import java.text.SimpleDateFormat;

import serializable.ISerializable;

public class Group implements ISerializable{

    Long id;
    String name;
    String tutor;
    Long level;

    public Group(String line){
        deserialize(line);
    }

    public Group(Long id, String name, String tutor, long level) {
        this.id = id;
        this.name = name;
        this.tutor = tutor;                        
        this.level = level;
    }

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {        
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getLevel() {
        return level;
    }

    public String getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return serialize();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this==obj ) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Group group = (Group) obj;
        return id.equals(group.getId());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
} 

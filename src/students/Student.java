package students;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import serializable.ISerializable;

public class Student implements ISerializable {
    Long id;
    String name;
    String surname;
    Date birthDate;
    long group_id;

    public Student(String line){
        deserialize(line);
    }
    public Student(Long id, String name, String surname, Date birthDate, long group_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.group_id = group_id;
    }
    public Student(Long id, String name, String surname, String birthDate, long group_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");            
        try{
            this.birthDate = format.parse(birthDate);   
        }
        catch(Exception e){
            this.birthDate = null;
        }
        
        this.group_id = group_id;
    }

    @Override
    public String serialize() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String birthDateString = formatter.format(this.birthDate);
        return String.format("%d;%s;%s;%s;%d", id, name, surname, birthDateString, group_id);
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthDateAsString(){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(this.birthDate);
    }

    @Override
    public String toString() {
        return serialize();
    }    

    @Override
    public boolean equals(Object obj) {
        if(this==obj ) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id.equals(student.getId());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    } 
}


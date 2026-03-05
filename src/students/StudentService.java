package students;

import files.StudentFileService;
import serializable.ISerializable;
import students.exceptions.ForeignKeyNotFound;
import students.exceptions.ItemAlreadyExists;

public class StudentService extends ModelService<Student>{

    GroupService groupService;
    
    public StudentService(String fileName, GroupService groupService) {
        super(new StudentFileService(fileName));
        this.groupService = groupService;
    }

    @Override
    public ISerializable create(ISerializable item) throws ItemAlreadyExists, ForeignKeyNotFound {
        if(!item.getClass().equals(Student.class))
            throw new IllegalArgumentException("El item debe ser de tipo Student");
        Student student = (Student) item;
        
        if(this.groupService.requestById(student.getGroup_id())!=null)        
            return super.create(item);
        throw new ForeignKeyNotFound("El grupo con id "+student.getGroup_id()+" no existe");
    }

    public ISerializable[] requestByGroup(Long id){
        return this.items
            .stream()
            .filter(item -> item!=null && item.getClass().equals(Student.class)?((Student)item).getGroup_id().equals(id):false)
            .toArray(Student[]::new);
    }
    
}
 
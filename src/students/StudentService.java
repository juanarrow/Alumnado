package students;

import files.StudentFileService;

public class StudentService extends ModelService<Student>{
    
    public StudentService(String fileName) {
        super(new StudentFileService(fileName));
    }
    
}

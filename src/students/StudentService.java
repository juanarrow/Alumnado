package students;

import files.StudentFileService;

public class StudentService extends ModelService<Student>{

    StudentFileService fileService;
    StudentService(String fileName) {
        super(fileName, new StudentFileService(fileName));
    }
    
}

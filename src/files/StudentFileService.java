package files;

import students.Student;

public class StudentFileService extends FileService<Student>{

    public StudentFileService(String filePath) {
        super(filePath);
    }
    
    @Override
    public Student deserialize(String line) {
        Student student = new Student();        
        return student.deserialize(line);
    }
    
}

package files;

import students.Student;

public class StudentFileService extends FileService<Student>{

    public StudentFileService(String filePath) {
        super(filePath);
    }
     
    @Override
    public Student deserialize(String line) {
        Student student = new Student(0L, "", "", "2000-01-01", 0L);        
        return student.deserialize(line);
    }
    
}

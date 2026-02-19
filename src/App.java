import java.util.List;

import files.GroupFileService;
import files.StudentFileService;
import students.Group;
import students.GroupService;
import students.Student;

public class App {
    public static void main(String[] args) throws Exception {         
        StudentFileService studentsFileService = new StudentFileService("students.txt");
        GroupFileService groupsFileService = new GroupFileService("groups.txt");
        List<Student> students = studentsFileService.readFromFile();
        List<Group> groups = groupsFileService.readFromFile();
        GroupService service = new GroupService("groups.txt");        
    }
}

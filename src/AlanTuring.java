import java.util.Date;

import serializable.ISerializable;
import students.Group;
import students.GroupService;
import students.ModelService;
import students.Student;
import students.StudentService;
import students.exceptions.ForeignKeyNotFound;
import students.exceptions.ItemAlreadyExists;


public class AlanTuring {
    GroupService groupService;
    StudentService studentService;
    

    public void menu(){
        System.out.println("1. List groups");
        System.out.println("2. List students");
        System.out.println("3. Add group");
        System.out.println("4. Add student");
        System.out.println("5. Update group");
        System.out.println("6. Update student");
        System.out.println("7. Delete group");
        System.out.println("8. Delete student");
        System.out.println("9. List students by group");

    }
 
    private void print(ModelService<? extends ISerializable> service){
        for(ISerializable o : service.requestAll()){
            System.out.println(o);
        }
    }
    public void listGroups(){
        print(groupService);        
    }

    public void listStudents(){
        print(studentService);
    }

    public void addStudent(){
        String name ="Antonio";
        String surname = "Doblas";
        String birthDate ="1990-01-01";
        long group_id = 10;
        ISerializable student = new Student(studentService.getNextId(), name, surname, birthDate, group_id);
        try{            
            student = studentService.create(student); 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void addGroup(){
        String name ="1ºDAW";
        String tutor = "Manuel";        
        Long level = 1L;        
        ISerializable group = new Group(groupService.getNextId(), name, tutor, level);
        try{            
            group = groupService.create(group);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void updateGroup(){
        Long id = 1L;
        Group group = (Group)groupService.requestById(id);
        Group newGroup = new Group(group.getId(), group.getName()+"_changed", group.getTutor()+"_changed", group.getLevel());
        try{
            groupService.update(newGroup);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void updateStudent(){
        Long id = 1L;
        Student student = (Student)studentService.requestById(id);
        Student newStudent = new Student(student.getId(), student.getName()+"_changed", student.getSurname()+"_changed", student.getBirthDate(), student.getGroup_id()); 
        try{
            studentService.update(newStudent);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }


    public void deleteStudent(){
        Long id = 1L;
        try{            
            studentService.delete(id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void deleteGroup(){
        Long id = 1L;
        try{            
            groupService.delete(id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listStudentsByGroup(){
        Long group_id = 2L;
        for(ISerializable item: studentService.requestByGroup(group_id)){
            System.out.println(item);
        }
    }

    public int getOption(){
        return Integer.parseInt(System.console().readLine("Option: "));
    }
    public AlanTuring(String studentsFileName, String groupsFileName) {
        this.groupService = new GroupService(groupsFileName);
        this.studentService = new StudentService(studentsFileName, groupService);
    }

    public void run(){
        int option = -1;
        do{
            menu();
            option = getOption();
            switch(option){
                case 1:
                    listGroups();
                    break;
                case 2:
                    listStudents();
                    break;                
                case 3:   
                    addGroup();
                    break;
                case 4:   
                    addStudent();
                    break;
                case 5:   
                    updateGroup();
                    break;
                case 6:   
                    updateStudent();
                    break;
                case 7:   
                    deleteGroup();
                    break;
                case 8:   
                    deleteStudent();
                    break;
                case 9:   
                    listStudentsByGroup();
                    break;
                default:             
            }

        }while(option!=7);
    }

}

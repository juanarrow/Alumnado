import serializable.ISerializable;
import students.Group;
import students.GroupService;
import students.ModelService;
import students.Student;
import students.StudentService;


public class AlanTuring {
    GroupService groupService;
    StudentService studentService;
    

    public void menu(){
        System.out.println("1. List groups");
        System.out.println("2. List students");
    }

    private void print(ModelService service){
        for(Object o : service.requestAll()){
            System.out.println(o);
        }
    }
    public void listGroups(){
        print(groupService);        
    }

    public void listStudents(){
        print(studentService);
    }

    public int getOption(){
        return Integer.parseInt(System.console().readLine("Option: "));
    }
    public AlanTuring(String studentsFileName, String groupsFileName) {
        this.groupService = new GroupService(groupsFileName);
        this.studentService = new StudentService(studentsFileName);
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
                    break;
                default:             
            }

        }while(option!=3);
    }

}


public class App {
    public static void main(String[] args) throws Exception {         
        if(args.length < 2){
            System.out.println("Usage: java App <students_file> <groups_file>");
            return;
        }
        String studentsFile = args[0];
        String groupsFile = args[1];
        AlanTuring app = new AlanTuring(studentsFile, groupsFile);
        app.run();
    }
}

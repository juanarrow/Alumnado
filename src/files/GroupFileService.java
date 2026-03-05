package files;

import students.Group;
 
public class GroupFileService extends FileService<Group>{

    public GroupFileService(String filePath) {
        super(filePath);
    }

    @Override
    public Group deserialize(String line) {
        return new Group(0L, "", "", 0L).deserialize(line);
    }

        
    
}

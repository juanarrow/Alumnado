package files;

import java.util.List;

import students.Group;

public class GroupFileService extends FileService<Group>{

    public GroupFileService(String filePath) {
        super(filePath);
    }

    @Override
    public Group deserialize(String line) {
        Group group = new Group();        
        return group.deserialize(line);
    }

        
    
}

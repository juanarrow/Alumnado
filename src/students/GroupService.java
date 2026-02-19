package students;

import files.GroupFileService;

public class GroupService extends ModelService<Group> {

    GroupFileService fileService;
    public GroupService(String fileName) {
        super(fileName, new GroupFileService(fileName));        
    }
    
    
}

package students;

import files.GroupFileService;

public class GroupService extends ModelService<Group> {
    
    public GroupService(String fileName) {
        super(new GroupFileService(fileName));        
    }
    
    
}
 
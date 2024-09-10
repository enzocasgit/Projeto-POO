package Repository;

// Java Imports
import java.util.*;

// Local Imports
import Model.User;

public class Repository {
    private List<User> _userList;
    
    public Repository()
    {
        _userList = new ArrayList<User>();
    }

    public List<User> getUserList()
    {
        return _userList;
    }

    public void addUser(User newUser)
    {
        _userList.add(newUser);
    }
}

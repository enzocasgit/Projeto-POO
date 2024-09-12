package Repository;

// Java Imports
import java.util.*;

import Model.Item;
// Local Imports
import Model.User;

public class Repository {
    private List<User> _userList;
    private List<Item> _itemList;
    
    public Repository()
    {
        _userList = new ArrayList<User>();
        _itemList = new ArrayList<Item>();
    }

    public List<User> getUserList()
    {
        return _userList;
    }

    public List<Item> getItemList()
    {
        return _itemList;
    }

    public void addUser(User newUser)
    {
        _userList.add(newUser);
    }

    public void addItem(Item newItem)
    {
        _itemList.add(newItem);
    }
}

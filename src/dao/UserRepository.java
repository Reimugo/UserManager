package dao;

import domain.User;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class UserRepository {
    private static final String DEFAULT_FILENAME = "user.dat";

    private List<User> userList;

    @SuppressWarnings("unchecked")
    private UserRepository() {
        userList = (List<User>)DaoUtil.loadDataFromFile(DEFAULT_FILENAME);
        if(userList == null)
            userList = new Vector<>();
    }

    private static class SingletonFactory{
        private static UserRepository singleton = new UserRepository();
    }

    public static UserRepository getInstance(){
        return SingletonFactory.singleton;
    }

    public void addUser(User user){
        userList.add(user);
        DaoUtil.saveDataToFile(userList, DEFAULT_FILENAME);
    }

    public User getUserByUsername(String username){
        Iterator<User> userIterator = userList.iterator();
        while(userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }
}

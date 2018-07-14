package dao;

import domain.User;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class UserRepository {
    private List<User> userList;

    private UserRepository() {
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

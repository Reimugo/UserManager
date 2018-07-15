package service;

import dao.UserRepository;
import domain.User;

public class UserService {

    private UserService() { }

    private static class SingletonFactory{
        private static UserService singleton = new UserService();
    }

    public static UserService getInstance(){
        return UserService.SingletonFactory.singleton;
    }


    /**查询指定用户名的用户是否存在
     * @param username 用户名
     * @return 成功返回对应用户的User对象，失败返回null（用户名不存在）
     * */
    public User queryUser(String username){
        return UserRepository.getInstance().getUserByUsername(username);
    }

    /**注册用户
     * @param username 用户名
     * @param password 密码
     * @return 成功返回true，失败返回false（用户名已存在的情况）
     * */
    public boolean register(String username, String password){
        if(UserRepository.getInstance().getUserByUsername(username) != null)
            return false;

        UserRepository.getInstance().addUser(new User(username, password));
        return true;
    }

    /**检测用户名密码是否正确，用于登录
     * @param username 用户名
     * @param password 密码
     * @return 成功返回true，失败返回false
     * */
    public boolean authorize(String username, String password){
        User userMatch = UserRepository.getInstance().getUserByUsername(username);
        if(userMatch == null){
            return false;
        }

        if(userMatch.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}

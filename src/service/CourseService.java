package service;

import dao.CourseRepository;
import dao.UserRepository;
import domain.Course;
import domain.User;

import java.util.List;
import java.util.Set;

public class CourseService {
    private CourseService(){}

    private static class SingletonFactory{
        private static CourseService singleton = new CourseService();
    }

    public static CourseService getInstance(){
        return SingletonFactory.singleton;
    }

    /**取所有课程的列表
     * @return 课程列表
     * */
    public List<Course> getAllCourse(){
        return CourseRepository.getInstance().getAllCourse();
    }

    /**开课
     * @param creatorUsername 开课老师用户名
     * @param courseName 课程名称
     * @return 成功返回true，失败返回false（开课用户名不存在）
     * */
    public boolean createCourse(String creatorUsername, String courseName){
        User creator = UserRepository.getInstance().getUserByUsername(creatorUsername);
        if(creator == null)
            return false;

        CourseRepository.getInstance().addCourse(new Course(courseName, creator));

        return true;
    }

    /**选课
     * @param username 选课者的用户名
     * @param courseId 课程对象ID
     * @return 成功返回true，失败返回false（选课者和开课者重复）
     * */
    public boolean selectCourse(String username, Integer courseId){
        User user = UserRepository.getInstance().getUserByUsername(username);
        Course course = CourseRepository.getInstance().getCourseById(courseId);

        if(course.getCreator().equals(user))
            return false;

        Set<Course> courses = user.getCourses();
        courses.add(course);
        user.setCourses(courses);

        return true;
    }

    /**获取一个用户已选择的课程
     * @param username 选课者的用户名
     * @return 已选课程的集合
     * */
    public Set<Course> getSelectedCourse(String username){
        return UserRepository.getInstance().getUserByUsername(username).getCourses();
    }


    /**获取一个用户已开设的课程
     * @param username 开课者的用户名
     * @return 已开设课程的集合
     * */
    public List<Course> getCreatedCourse(String username){
        return CourseRepository.getInstance().getCoursesByCreator(UserRepository.getInstance().getUserByUsername(username));
    }

    /**根据课程名获取一个已开设的课程Course对象
     * @param courseName 开课者的User对象
     * @return 课程名对应的Course对象
     * */
    public Course getCourseByName(String courseName){
        return CourseRepository.getInstance().getCourseByName(courseName);
    }

    public Course getCourseById(int id){
        return CourseRepository.getInstance().getCourseById(id);
    }

}

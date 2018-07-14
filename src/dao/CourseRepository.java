package dao;

import domain.Course;
import domain.User;

import java.util.List;
import java.util.Vector;

public class CourseRepository {
    private List<Course> courseList;

    private CourseRepository(){
        courseList = new Vector<>();
    }

    private static class SingletonFactory{
        private static CourseRepository singleton = new CourseRepository();
    }

    public static CourseRepository getInstance(){
        return SingletonFactory.singleton;
    }

    public List<Course> getAllCourse(){
        return new Vector<>(courseList);
    }

    public void addCourse(Course course){
        courseList.add(course);
    }

    public List<Course> getCoursesByCreator(User creator){
        List<Course> list = new Vector<>();
        for(Course course : courseList){
            if(course.getCreator().equals(creator))
                list.add(course);
        }
        return list;
    }

}

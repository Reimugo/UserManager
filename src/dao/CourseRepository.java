package dao;

import domain.Course;
import domain.User;

import java.util.List;
import java.util.Vector;

public class CourseRepository {
    private static final String DEFAULT_FILENAME = "course.dat";

    private List<Course> courseList;

    @SuppressWarnings("unchecked")
    private CourseRepository(){
        courseList = (List<Course>)DaoUtil.loadDataFromFile(DEFAULT_FILENAME);
        if(courseList == null)
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

    public Course getCourseById(int id){
        for(Course course : courseList){
            if(course.getId() == id)
                return course;
        }
        return null;
    }

    public void addCourse(Course course){
        courseList.add(course);

        DaoUtil.saveDataToFile(courseList, DEFAULT_FILENAME);
    }

    public List<Course> getCoursesByCreator(User creator){
        List<Course> list = new Vector<>();
        for(Course course : courseList){
            if(course.getCreator().equals(creator))
                list.add(course);
        }
        return list;
    }

    public Course getCourseByName(String courseName){
        for(Course course : courseList){
            if(course.getName().equals(courseName))
                return course;
        }
        return null;
    }

}

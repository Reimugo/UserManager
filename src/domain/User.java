package domain;

import dao.CourseRepository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {
    private String username;
    private String password;
    private Set<Integer> coursesId;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        coursesId = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Course> getCourses() {
        Set<Course> courses = new HashSet<>();
        for(int id : coursesId){
            courses.add(CourseRepository.getInstance().getCourseById(id));
        }
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        coursesId.clear();
        for(Course course : courses){
            coursesId.add(course.getId());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username);
    }
}

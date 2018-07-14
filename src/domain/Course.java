package domain;

import java.util.Objects;

public class Course {
    private String name;
    private User creator;

    public Course(String name, User creator) {
        this.name = name;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) &&
                Objects.equals(creator, course.creator);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, creator);
    }
}

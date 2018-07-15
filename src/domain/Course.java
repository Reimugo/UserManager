package domain;

import dao.UserRepository;

import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable {
    private static int maxId = 0;

    private int id;
    private String name;
    private String creatorUsername;

    public Course(String name, User creator) {
        this(++maxId, name, creator);
    }

    public Course(int id, String name, User creator) {
        this.id = id;
        this.name = name;
        this.creatorUsername = creator.getUsername();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return UserRepository.getInstance().getUserByUsername(creatorUsername);
    }

    public void setCreator(User creator) {
        this.creatorUsername = creator.getUsername();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(creatorUsername, course.creatorUsername);
    }

    @Override
    public int hashCode() {

        return Objects.hash(creatorUsername);
    }
}

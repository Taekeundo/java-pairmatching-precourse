package pairmatching.domain;

public class Crew {

    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }
}

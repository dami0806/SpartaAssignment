package student.models;

import course.models.Course;

import java.util.List;

/**
 * state(상태), courses(수강목록)
 */
public class Student extends Person {
    private String state;
    private List<Course> courseList;

    public Student(int id, String name, String state, List<Course> courseList) {
        super(id, name);
        this.state = state;
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

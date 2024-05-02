package student.models;

import course.models.Course;

import java.util.List;

/**
 * state(상태), courses(수강목록) 필수, 선택 분리해서
 */
public class Student extends Person {
    private String state;
    private List<Course> CourseEnrollment;

    public Student(int id, String name, String state, List<Course> courseEnrollment) {
        super(id, name);
        this.state = state;
        CourseEnrollment = courseEnrollment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Course> getCourseEnrollment() {
        return CourseEnrollment;
    }

    public void setCourseEnrollment(List<Course> courseEnrollment) {
        CourseEnrollment = courseEnrollment;
    }
}
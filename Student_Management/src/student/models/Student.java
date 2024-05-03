package student.models;

import course.models.Course;
import course.models.CourseEnrollment;

import java.util.List;
import java.util.Map;

/**
 * state(상태), courses(수강목록) 필수, 선택 분리해서
 */
public class Student extends Person {
    private String state;
    private Map<String, CourseEnrollment> courses;

    public Student(int id, String name, String state, Map<String, CourseEnrollment> courses) {
        super(id, name);
        this.state = state;
        this.courses = courses;
    }

    public void addCourse(String courseId, CourseEnrollment courseEnrollment) {
        courses.put(courseId, courseEnrollment);
    }
}
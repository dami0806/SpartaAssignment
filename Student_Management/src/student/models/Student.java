package student.models;

import course.models.Course;
import course.models.CourseEnrollment;

import java.util.HashMap;
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

    // 강의 추가
    public void addCourse(List<Course> coursesToAdd) {
        for (Course course : coursesToAdd) {
            CourseEnrollment courseEnrollment = new CourseEnrollment(course, new HashMap<>());
            courses.put(course.getCourseId(), courseEnrollment);
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, CourseEnrollment> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, CourseEnrollment> courses) {
        this.courses = courses;
    }
}
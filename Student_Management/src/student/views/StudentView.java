package student.views;

import course.models.CourseEnrollment;

import java.util.Map;

public class StudentView {

    public void printStudentDetails(int id, String name, String state, Map<String, CourseEnrollment> courses) {

        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("State: " + state);
        System.out.println("Courses:");
        for (Map.Entry<String, CourseEnrollment> entry : courses.entrySet()) {
            System.out.println("Course ID: " + entry.getKey() + ", Course Name: " + entry.getValue().getCourse().getCourseName());
        }
    }
}

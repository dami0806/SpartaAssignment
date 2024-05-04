package student.controllers;

import course.models.Course;
import course.models.CourseEnrollment;
import student.models.Student;
import student.views.StudentView;

import java.util.HashMap;
import java.util.List;

public class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setView(StudentView view) {
        this.view = view;
    }

    public void addCourses(List<Course> coursesToAdd) {

        for (Course course : coursesToAdd) {
            // enroll
            CourseEnrollment courseEnrollment = new CourseEnrollment(course, new HashMap<>());
            student.getCourses().put(course.getCourseId(), courseEnrollment);
        }
    }

    public void updateView() {
        StudentView.displayStudentDetails(student);
    }
}

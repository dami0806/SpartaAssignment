package exception.student;

import course.models.CourseEnrollment;
import student.models.Student;

import java.io.BufferedReader;

public class InvalidStudentIdException extends StudentException {
    public InvalidStudentIdException(String message) {
        super(message);
    }

    public static void handleAddScores(BufferedReader br, Student student) {

    }

    public static void getAddScoreSession(BufferedReader br, Student student, CourseEnrollment courseEnrollment) {
    }
}

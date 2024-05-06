package exception.course;

import course.models.CourseEnrollment;

// 과목 예외처리
public class CourseException extends Exception {
    public CourseException(String message) {
        super(message);
    }
}

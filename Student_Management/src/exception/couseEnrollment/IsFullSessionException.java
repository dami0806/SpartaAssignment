package exception.couseEnrollment;

import exception.course.CourseException;

public class IsFullSessionException extends CourseException {
    public IsFullSessionException(String message) {
        super(message);
    }
}

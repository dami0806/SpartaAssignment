package exception.couseEnrollment;

import exception.course.CourseException;

public class InvalidSessionException extends CourseException {
    public InvalidSessionException(String message) {
        super(message);
    }
}

package exception.score;

import exception.course.CourseException;

public class InvalidScoreException extends CourseException {
    public InvalidScoreException(String message) {
        super(message);
    }
}

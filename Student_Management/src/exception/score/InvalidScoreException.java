package exception.score;

import exception.course.CourseException;

public class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

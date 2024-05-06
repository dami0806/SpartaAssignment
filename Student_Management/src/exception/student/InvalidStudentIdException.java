package exception.student;

public class InvalidStudentIdException extends StudentException {
    public InvalidStudentIdException(String message) {
        super(message);
    }
}

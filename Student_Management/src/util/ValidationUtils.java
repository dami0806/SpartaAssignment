package util;

import course.models.CourseEnrollment;
import exception.course.InvalidCourseException;
import exception.couseEnrollment.InvalidSessionException;
import exception.score.InvalidScoreException;
import student.models.Student;

import java.io.BufferedReader;
import java.io.IOException;

public class ValidationUtils {
    // 유효한 과목 ID 확인
    // 유효한 과목ID
    public static String getValidCourseId(BufferedReader br, Student student) throws InvalidCourseException, IOException {
        System.out.println("과목의 ID를 입력하세요:");
        String courseId = br.readLine().trim();

        if (!student.getCourses().containsKey(courseId)) {
            throw new InvalidCourseException(ErrorMessage.INVALID_COURSE_ID.getMessage());
        }
        return courseId;
    }

    // 유효한 섹션
    public static int getValidSession(BufferedReader br, CourseEnrollment courseEnrollment) throws
            InvalidSessionException, IOException {
        System.out.println("수정할 회차를 입력하세요:");
        int session = Integer.parseInt(br.readLine().trim());
        if (session < 1 || session > 10 || !courseEnrollment.getScoresBySession().containsKey(session)) {
            throw new InvalidSessionException(ErrorMessage.INVALID_SESSION.getMessage());
        }
        return session;
    }

    // 유효한 점수 확인
    public static int getValidScore(BufferedReader br) throws IOException, InvalidScoreException {
        try {
            int newScore = Integer.parseInt(br.readLine());
            if (newScore < 0 || newScore > 100) {
                throw new InvalidScoreException(ErrorMessage.INVALID_SCORE.getMessage());
            }
            return newScore;

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}

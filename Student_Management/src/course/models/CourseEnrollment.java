package course.models;

import Score.models.Score;

import java.lang.reflect.AnnotatedType;
import java.util.Map;

public class CourseEnrollment {
    private Course course;
    private Map<Integer, Score> scoresBySession; // 개별 회차별 Score 객체 저장

    public Map<Integer, Score> getScoresBySession() {
        return scoresBySession;
    }
}

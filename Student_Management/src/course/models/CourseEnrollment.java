package course.models;

import Score.models.Score;

import java.util.Map;

public class CourseEnrollment {
    private Course course;
    private String type;  // "required" or "elective"
    private Map<Integer, Score> scoresBySession; // 개별 회차별 Score 객체 저장
}

package course.models;

import java.util.ArrayList;
import java.util.List;

// 더미데이터
public class CourseData {

    private static List<Course> courses = new ArrayList<>();
    // 더미 데이터 생성
    public static void createCourseList() {
        // 필수 과목
        courses.add(new Course("C01", "Java", "required"));
        courses.add(new Course("C02", "객체지향", "required"));
        courses.add(new Course("C03", "Spring", "required"));
        courses.add(new Course("C04", "JPA", "required"));
        courses.add(new Course("C05", "MySql", "required"));

        // 선택 과목
        courses.add(new Course("D01", "디자인패턴", "elective"));
        courses.add(new Course("D02", "Spring Security", "elective"));
        courses.add(new Course("D03", "Redis", "elective"));
        courses.add(new Course("D04", "MongoDB", "elective"));

    }

    // 더미데이터 전체 불러오기
    public static List<Course> getCourseList() {
        return courses;
    }
}

package course.models;

import java.util.ArrayList;
import java.util.List;

// 더미데이터
public class CourseData {

    public static List<Course> getCourseList() {
        List<Course> courses = new ArrayList<>();
        // 필수 과목
        courses.add(new Course("C01", "Java", "required"));
        courses.add(new Course("C02", "객체지향", "required"));
        courses.add(new Course("C03", "Spring", "required"));
        courses.add(new Course("C04", "JPA", "required"));
        courses.add(new Course("C05", "MySql", "required"));

        // 선택 과목
        courses.add(new Course("C06", "디자인패턴", "elective"));
        courses.add(new Course("C07", "Spring Security", "elective"));
        courses.add(new Course("C08", "Redis", "elective"));
        courses.add(new Course("C09", "MongoDB", "elective"));

        return courses;
    }

}

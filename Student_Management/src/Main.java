import course.models.Course;
import course.models.CourseData;
import course.models.CourseEnrollment;
import student.models.IDGenerator;
import student.models.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static course.models.CourseData.createCourseList;
import static course.models.CourseData.getCourseList;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 학생 고유번호 생성
        int studentId = IDGenerator.getInstance().generateId();

        // 1. 학생 이름 등록
        System.out.print("학생 이름을 입력하세요: ");
        String name = br.readLine();


        // 2. 과목 선택
        CourseData.createCourseList();
        List<Course> allCourses = CourseData.getCourseList();
        // 필수 과목만 필터링
        List<Course> requiredCoursesList = allCourses.stream()
                .filter(course -> course.getType().equals("required"))
                .collect(Collectors.toList());

        List<Course> electiveCoursesList = allCourses.stream()
                .filter(course -> course.getType().equals("elective"))
                .collect(Collectors.toList());

        System.out.println("선택할 수 있는 과목 목록: ");

        // 필수과목 보기
        System.out.println("필수 과목:");
        for (Course course : requiredCoursesList) {
            if (course.getType().equals("required")) {
                System.out.printf(" %s |", course);
            }

        }
        //선택과목 보기
        System.out.println("\n\n선택 과목:");
        for (Course course : electiveCoursesList) {
            if (course.getType().equals("elective")) {
                System.out.printf(" %s |", course);
            }
        }
        // 필수 과목 선택
        List<Course> requiredCourses = selectCourses(br, "Required", requiredCoursesList);

        // 선택 과목 선택
        List<Course> electiveCourses = selectCourses(br, "Elective", electiveCoursesList);

        // 학생 객체 생성
        Student student = new Student(studentId, name, "good", new HashMap<>());

        // 과목을 학생에게 추가
        for (Course course : allCourses) {
            student.addCourse(course.getCourseId(), new CourseEnrollment(course));
        }

        // 학생의 선택 정보 출력
        System.out.println("학생 정보:");
        System.out.println("ID: " + student.getId());
        System.out.println("이름: " + student.getName());
        System.out.println("선택한 필수 과목:");
        for (Course course : requiredCourses) {
            System.out.println(course);
        }

        System.out.println("선택한 선택 과목:");
        for (Course course : electiveCourses) {
            System.out.println(course);
        }
    }

    // 과목 선택 메서드
// 과목 선택 메서드
    private static List<Course> selectCourses(BufferedReader br, String courseType, List<Course> course) throws IOException {
        List<Course> selectedCourses = new ArrayList<>();
        System.out.println("\n" + courseType + " Courses를 선택해주세요 최소 3개 이상");

        // 최소 3개 이상 선택하도록 반복
        while (selectedCourses.size() < 3) {
            System.out.print(courseType + " Course 선택: ");
            String courseId = br.readLine();

            // 선택한 과목이 필수 과목인지 확인
            Course selectedCourse = findCourse(courseId);

            if (selectedCourse != null) {
                if (selectedCourses.contains(selectedCourse)) {
                    System.out.println("이미 선택된 과목입니다.");
                    continue;
                }
                // 해야하는 과목 && 선택한 과목
                else if (courseType.equals("Required") && !course.contains(selectedCourse)) {
                    System.out.println("다음 과목은 선택 과목입니다. 다시 선택해세요.");
                    continue;

                }// 해야하는 과목 && 선택한 과목
                else if (courseType.equals("Elective") && !course.contains(selectedCourse)) {
                    System.out.println("다음 과목은 필수 과목입니다. 다시 선택해세요.");
                    continue;

                }
                selectedCourses.add(selectedCourse);

            } else {
                System.out.println("잘못된 과목 코드입니다. 다시 입력해주세요.");
                continue;

            }


        }
        return selectedCourses;
    }

    // 과목 검색 메서드
    private static Course findCourse(String courseId) {
        List<Course> courses = CourseData.getCourseList();
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}
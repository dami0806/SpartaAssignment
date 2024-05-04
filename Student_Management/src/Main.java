import Score.models.Score;
import course.models.Course;
import course.models.CourseData;
import course.models.CourseEnrollment;
import student.models.IDGenerator;
import student.models.Student;
import student.views.StudentView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static course.controllers.CourseEnrollmentController.handleAddScores;
import static course.controllers.CourseEnrollmentController.handleUpdateScores;

// 필수과목인지 선택과목인지 타입에 맞춰서 불러오기
// 과목 선택하기
//과목id -
//과목별 점수 입력하기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n==================================");
        System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
        System.out.println("1. 수강생 관리");
        System.out.println("2. 점수 관리");
        System.out.println("3. 프로그램 종료");
        System.out.print("관리 항목을 선택하세요...\n>> ");

        String input = br.readLine();
        switch (input) {
            case "1":
                handleStudentRegistration(br);
                break;
            case "2":
                // 점수 관리 핸들러 호출
                break;
            case "3":
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                break;
        }
    }

    //   학생이 등록될때 이름과 필수,선택 과목까지 입력을 해야 고유번호와 함께 생성
    private static void handleStudentRegistration(BufferedReader br) throws IOException {
        System.out.print("학생 이름을 입력하세요: ");
        String name = br.readLine();
        if (name.isEmpty()) {
            System.out.println("이름을 입력해야 합니다.");
            return;
        }

        CourseData.createCourseList();
        List<Course> allCourses = CourseData.getCourseList();
        List<Course> requiredCourses = filterCoursesByType(allCourses, "required");
        List<Course> electiveCourses = filterCoursesByType(allCourses, "elective");

        displayCourses("필수 과목", requiredCourses);
        displayCourses("선택 과목", electiveCourses);

        System.out.println("필수 과목 및 선택 과목 중에서 선택할 과목의 ID를 입력하세요 (예: C01 D02):");
        String[] courseIds = br.readLine().trim().split(" ");

        Map<String, CourseEnrollment> enrollments = new HashMap<>();

        for (String courseId : courseIds) {
            if (!courseId.isEmpty()) {
                Course course = allCourses.stream()
                        .filter(c -> courseId.equals(c.getCourseId()))
                        .findFirst().orElse(null);
                if (course != null) {
                    enrollments.put(course.getCourseId(), new CourseEnrollment(course, new HashMap<>()));
                } else {
                    System.out.println(" 과목이 존재하지 않습니다. 다시 입력해야 합니다.");
                }
            }
        }
        if (!enrollments.isEmpty()) {
            int studentId = IDGenerator.getInstance().generateId();
            Student student = new Student(studentId, name, "Active", enrollments);
            System.out.println("학생 등록이 완료되었습니다.");
            StudentView.displayStudentDetails(student);
        } else {
            System.out.println("최소개수의 과목을 선택하지 않아 학생을 등록할 수 없습니다.");
        }
    }
    
    // 필수과목인지 선택과목인지 타입에 맞춰서 불러오기
    private static List<Course> filterCoursesByType(List<Course> courses, String type) {
        return courses.stream()
                .filter(course -> course.getType().equals(type))
                .collect(Collectors.toList());
    }

    private static void displayCourses(String header, List<Course> courses) {
        System.out.println(header + ":");
        courses.forEach(course -> System.out.printf(" %s (%s) |", course.getCourseName(), course.getCourseId()));
        System.out.println("\n");
    }

    /**
     * 과목선택하기
     *
     * @param br:               입력값: 과목id
     * @param availableCourses: 중복이나 해당 종류가 아닌 과목 선택 방지
     * @param type:             필수과목, 선택과목
     * @return : 선택된 List<Course>
     * @throws IOException
     */
    private static List<Course> selectCourses(BufferedReader br, List<Course> availableCourses, String type) throws IOException {

        System.out.println("다음 중에서 " + type + " 과목을 최소 3개 선택해주세요:");
        List<Course> selectedCourses = new ArrayList<>();

        while (selectedCourses.size() < 3) {
            System.out.print("과목 ID를 입력하세요: ");
            String courseId = br.readLine().trim(); // C01

            if ("e".equalsIgnoreCase(courseId)) break;

            Course course = availableCourses.stream()
                    .filter(c -> courseId.equals(c.getCourseId()))
                    .findFirst()
                    .orElse(null);

            if (course != null && !selectedCourses.contains(course)) {
                selectedCourses.add(course);
                System.out.println(course.getCourseName() + " 추가됨.");
            } else {
                System.out.println("유효하지 않거나 이미 추가된 과목입니다. 다시 입력해주세요.");
            }
        }
        return selectedCourses;
    }
}

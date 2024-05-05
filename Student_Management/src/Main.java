import Score.models.Score;
import course.controllers.CourseEnrollmentController;
import course.models.Course;
import course.models.CourseData;
import course.models.CourseEnrollment;
import student.StudentManager;
import student.controllers.StudentController;
import student.models.IDGenerator;
import student.models.Student;
import student.views.StudentView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


// 필수과목인지 선택과목인지 타입에 맞춰서 불러오기
// 과목 선택하기
//과목id -
//과목별 점수 입력하기

public class Main {
    private static StudentManager studentManager = new StudentManager();
    private static StudentView studentView = new StudentView();
    private static StudentController studentController;

    public static void main(String[] args) throws IOException {
        studentController = new StudentController(studentView, studentManager);
        mainPage();
    }

    private static void mainPage() throws IOException {
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
                studentManageSession(br);
                break;
            case "2":
                //  메인 >> 2 선택 시 : 수강생 리스트 쭉 보여주고 수강생 번호 입력하기
                studentManager.displayAllStudents();
                manageScores(br);
                // 수강생 번호 입력하기
                System.out.println("수강생 번호를 입력하세요:");

                // 점수 관리 핸들러 호출
                //studentController.handleUpdateName(new BufferedReader(new InputStreamReader(System.in)));
                mainPage();

                break;
            case "3":
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                mainPage();
                break;
        }
    }

    // 선택된 학생에 대한 과목
    private static void manageScores(BufferedReader br) throws IOException {

        System.out.println("수강생 번호를 입력하세요:");
        int studentId = Integer.parseInt(br.readLine());
        Student student = studentManager.getStudent(studentId);
        scoreSettingSession(br, student);

        if (student == null) {
            System.out.println("없는 학생입니다. 다시 시도하세요.");
            manageScores(br); // 재시도
        }
    }

    private static void scoreSettingSession(BufferedReader br, Student student) throws IOException {
        //2 점수관리
        System.out.println("==================================");
        System.out.println("점수 관리 실행 중...");
        System.out.println("1. 수강생의 점수등록");
        System.out.println("2. 수강생의 과목별 회차 점수 수정");
        System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
        System.out.println("4. 다른 수강생 선택하기");
        System.out.println("0. 메인 화면 이동");

        String input = br.readLine();

        switch (input) {
            case "1":
                CourseEnrollmentController.handleAddScores(br, student);
                break;
            case "2":
                CourseEnrollmentController.handleUpdateScores(br, student);
                break;
            case "3":
                // 수강생의 특정 과목 회차별 등급 조회
                CourseEnrollmentController.displaySessionGrades(br, student);
               // scoreSettingSession(br, student);
                break;
            case "4":
                manageScores(br);
                break;
            case "0":
                mainPage();
                break;
            default:
                System.out.println("관리 항목을 선택하세요");
                scoreSettingSession(br, student); // 재호출
        }
    }

    private static void studentManageSession(BufferedReader br) throws IOException {
        System.out.println("==================================");
        System.out.println("수강생 관리 실행 중...");
        System.out.println("1. 수강생 등록");
        System.out.println("2. 수강생 목록 조회");
        System.out.println("3. 수강생 정보 수정");
        System.out.println("4. 수강생 정보 삭제");
        System.out.println("5. 메인 화면 이동");

        System.out.print("관리 항목을 선택하세요...\n>>");

        String input = br.readLine();

        switch (input) {
            case "1":
                handleStudentRegistration(br);
                break;
            case "2":
                //  메인 >> 2 선택 시 : 수강생 리스트 쭉 보여주고 수강생 번호 입력하기
                studentView.displaysAllStudents(studentManager.getAllStudents());
                mainPage();
                ;
                // 점수 관리 핸들러 호출
                break;
            case "3":
                studentController.handleUpdateName(br);
                mainPage();
                break;
            case "4":
                studentController.handleDeleteName(br);
                mainPage();
                break;
            case "5":
                mainPage();
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                studentManageSession(br);
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
            studentManager.addStudent(student);

            System.out.println("학생 등록이 완료되었습니다.");
            StudentView.displayStudentDetails(student);
            mainPage();
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
}

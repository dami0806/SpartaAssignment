import Score.models.Score;
import course.controllers.CourseEnrollmentController;
import course.models.Course;
import course.models.CourseData;
import course.models.CourseEnrollment;
import exception.student.InvalidStudentIdException;
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

// 구조확인
// 재활용이나 객체 생성
// 초기 생성자만들때 모두 안넣는경우
// 객체 생성 없이 와 static객체 생성 studentController
// -> static으로 올릴때 고려할점 1. 이 프로세스 동작중 해당 스레드가 이 인스턴스를 보호할 수 있는지(이미 한명)
// 프로세스가 죽어도 남아있는 static
// 경우 실패시 재귀 호출 or else if 실패문 or > 예외처리 다시처리 =
// 예외처리 던질때 클래스, 분리에 대해서
// getter setter 사용 안할때도 만들어 놓고 있는지-> 지양

// 코드에 대한 리뷰필요..
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

        System.out.println("\n==============[수강생관리 메인화면]====================");
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
    private static void manageScores(BufferedReader br) {
        try {
            System.out.println("수강생 번호를 입력하세요:");
            int studentId = studentController.getValidStudentId(br);

            Student student = studentManager.getStudent(studentId);
            scoreSettingSession(br, student);

            if (student == null) {
                System.out.println("없는 학생입니다. 다시 시도하세요.");
                manageScores(br); // 재시도
            }
        } catch (InvalidStudentIdException e){
            System.out.println(e.getMessage());

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    private static void scoreSettingSession(BufferedReader br, Student student) throws IOException {
        //2 점수관리
        System.out.println("==============[2. 점수 관리 페이지]====================");
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
                studentController.handelStudentRegistration(br);
                mainPage();
                break;
            case "2":
                //  메인 >> 2 선택 시 : 수강생 리스트 쭉 보여주고 수강생 번호 입력하기
                studentView.displaysAllStudents(studentManager.getAllStudents());
                mainPage();

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
}

package student.controllers;

import course.models.Course;
import course.models.CourseEnrollment;
import student.StudentManager;
import student.models.Student;
import student.views.StudentView;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class StudentController {
    private Student student;
    private StudentView view;
    private StudentManager studentManager;

    public StudentController(StudentView view, StudentManager studentManager) {
        this.view = view;
        this.studentManager = studentManager;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setView(StudentView view) {
        this.view = view;
    }

    public void addCourses(List<Course> coursesToAdd) {

        for (Course course : coursesToAdd) {
            // enroll
            CourseEnrollment courseEnrollment = new CourseEnrollment(course, new HashMap<>());
            student.getCourses().put(course.getCourseId(), courseEnrollment);
        }
    }

    //학생 이름 수정하기
    public void handleUpdateName(BufferedReader br) throws IOException {
        view.displayBasicInfoStudent(studentManager.getAllStudents());

        System.out.println("이름을 변경할 학생의 고유번호를 입력하세요:");

        int studentId = getValidStudentId(br); // 고유번호 입력 받기

        Student studentToUpdate = studentManager.getStudentById(studentId);
        if (studentToUpdate != null) {
            System.out.printf("변경하실 이름을 입력하세요 \n [현재 이름: %s] >> : ", studentToUpdate.getName());
            String newName = br.readLine().trim(); // 새 이름 입력 받기
            studentToUpdate.setName(newName); // 이름 변경
            System.out.println("이름이 성공적으로 변경되었습니다.");
        } else {
            System.out.println("해당 고유번호를 가진 학생이 존재하지 않습니다.");
        }
    }

    // 학생 지우기
    public void handleDeleteName(BufferedReader br) throws IOException {
        view.displayBasicInfoStudent(studentManager.getAllStudents());

        System.out.println("삭제할 학생의 고유번호를 입력하세요:");

        int studentId = getValidStudentId(br); // 고유번호 입력 받기

        Student studentToUpdate = studentManager.getStudentById(studentId);
        if (studentToUpdate != null) {
            System.out.printf("삭제할 이름을 확인하세요 \n [현재 이름: %s]수강생을 정말 삭제하시겠습니까?(Y/N)\n >> : ", studentToUpdate.getName());
            String answer = br.readLine().trim();
            studentManager.deleteStudent(studentId);
            System.out.println("성공적으로 삭제되었습니다.");
        } else {
            System.out.println("해당 고유   번호를 가진 학생이 존재하지 않습니다.");
        }
    }

    // 유효한 학생 id
    private int getValidStudentId(BufferedReader br) throws IOException {
        while (true) {
            try {
                System.out.print("학생 고유번호를 입력하세요: ");
                int studentId = Integer.parseInt(br.readLine().trim());
                if (studentManager.getStudentById(studentId) != null) {
                    return studentId;
                } else {
                    System.out.println("해당 고유번호를 가진 학생이 존재하지 않습니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력하세요.");
            }
        }
    }
}

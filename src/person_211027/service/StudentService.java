package person_211027.service;

import person_211027.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService extends PersonService{
    private ArrayList<Student> studentList;

    public StudentService() {
        studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    public void sortByAverageScore() {

    }
    public static Student createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        System.out.print("Nhập điểm toán: ");
        double math = scanner.nextDouble();
        System.out.print("Nhập điểm toán: ");
        double physical = scanner.nextDouble();
        System.out.print("Nhập điểm toán: ");
        double chemistry = scanner.nextDouble();
        return new Student(name, age, math, physical, chemistry);
    }

}

package person_211027.service;

import person_211027.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StudentService extends PersonService{

    private ArrayList<Student> studentList;

    public StudentService() {
        studentList = new ArrayList<>();
    }

    public StudentService(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void sortByAverageScore() {
        Collections.sort(studentList);
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

    public void findMaxAvgScore() {
        double max = studentList.get(0).getAverageScore();
        int index = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (max < studentList.get(i).getAverageScore()) {
                max = studentList.get(i).getAverageScore();
                index = i;
            }
        }
        System.out.println();
        System.out.println("Học sinh có điểm cao nhất: ");
        printFullLine();
        System.out.println(studentList.get(index));
        printFullLine();
    }

    public void print() {
        System.out.println();
        System.out.println("Danh sách học sinh: ");
        printFullLine();
        System.out.printf("|%-8s|%-10s|%-7s|%-13s|%-13s|%-13s|%-13s|%n",
                "Tên", "ID", "Tuổi", "Điểm toán", "Điểm lý", "Điểm Hóa", "Điểm TB");
        printFullLine();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        printFullLine();
    }
}

package person_211027.menu;

import person_211027.model.Student;
import person_211027.service.PersonService;
import person_211027.service.StudentService;

import java.util.Scanner;

public class MenuPerson {
    public PersonService personService = new PersonService();
    public void showMenu() {
        System.out.println("Menu");
        System.out.println("1. Thêm người vào danh sách");
        System.out.println("2. In danh sách");
        System.out.println("3. Xóa thành viên trong danh sách");
        System.out.println("4. Sửa thành viên trong danh sách");
        System.out.println("5. Tìm kiếm thành viên theo tên");
        System.out.println("6. Sắp xếp danh sách theo điểm trung bình");
        System.out.println("0. Kết thúc chương trình");
        System.out.println("Vui lòng lựa chọn: ");
    }
    public void addObject() {
        int option = -1;
        while (option != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập tùy chọn: ");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Thêm giáo viên");
            System.out.println("0. Hoạt động khác");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    StudentService.createStudent();
                    break;
                case 0:
                    System.out.println("Mời thực hiện những hành động tiếp theo.");
                    break;
                default:
                    System.out.println("Không có tùy chọn!");
            }
        }
    }
    public void printObject() {
        personService.print();
    }
    public void deleteObject() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập id của học sinh cần xóa: ");
        int deleteId = scanner.nextInt();
        personService.deleteById(deleteId);
    }
    public void editObject() {
        System.out.print("Nhập id của thành viên cần sửa: ");
        Scanner scanner = new Scanner(System.in);
        int editId = scanner.nextInt();
        int index = personService.findIndexById(editId);
        if (index != -1) {
            if (personService.getPersonList().get(index) instanceof Student){
                personService.editById(editId, StudentService.createStudent());
            }
        } else {
            System.out.println("Không có học sinh tương ứng với id này.");
        }
    }
}

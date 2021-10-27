package person_211027.menu;

import person_211027.model.Student;
import person_211027.service.PersonService;
import person_211027.service.StudentService;

import java.util.ArrayList;

public class MenuStudent extends MenuPerson{

    public StudentService createStudentList(PersonService personService) {
        StudentService studentService1 = new StudentService();
        ArrayList<Student> studentService2 = new ArrayList<>();
        for (int i = 0; i < personService.getPersonList().size(); i++) {
            if (personService.getPersonList().get(i) instanceof Student){
                Student student = (Student) personService.getPersonList().get(i);
                studentService2.add(student);
            }
        }
        studentService1.setStudentList(studentService2);
        return studentService1;
    }

    public void sortIncreaseStudent() {
        StudentService studentList1 = createStudentList(personService);
        studentList1.sortByAverageScore();
        studentList1.print();
    }


    public static void main(String[] args) {
        PersonService myPersonList = new PersonService();
        myPersonList.add(new Student("Hoa", 20,6,4,5));
        myPersonList.add(new Student("Lan", 21,7,4,5));
        myPersonList.add(new Student("Hương", 29,8,6,1));
        myPersonList.add(new Student("Thủy", 28,10,7,9));
        myPersonList.add(new Student("Hường", 27,5,8,8));
        myPersonList.add(new Student("Lan", 22,4,9,10));
        myPersonList.add(new Student("Anh", 25,3,10,5));
        myPersonList.add(new Student("Chi tử", 20,6,8,7));

        myPersonList.print();

        MenuStudent menuStudent = new MenuStudent();
        StudentService myStudentList1 = menuStudent.createStudentList(myPersonList);
        myStudentList1.findMaxAvgScore();
        myPersonList.editById(6, new Student("Tiên", 27,7,7,6));
        myPersonList.add(new Student("Hưng", 26,10,10,10));
        myPersonList.print();
        myPersonList.deleteById(8);
        myPersonList.add(new Student("Hòa", 26,9,9,9));
        myPersonList.print();
        myStudentList1.sortByAverageScore();
        myStudentList1.print();
    }
}

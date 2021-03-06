package person_211027.menu;

import person_211027.model.Person;
import person_211027.model.Student;
import person_211027.service.PersonService;
import person_211027.service.StudentService;

import java.io.*;
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

    public void writeStudentList(PersonService personService, String nameFile) throws IOException {
        FileWriter fileWriter = new FileWriter(nameFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "Name,ID,Age,Math Score,Physical Score,Chemistry Score,Average Score";
        for (int i = 0; i < personService.getPersonList().size(); i++) {
            Student student = (Student) personService.getPersonList().get(i);
            str += "\n";
            str += student.getName() + ",";
            str += student.getPersonalId() + ",";
            str += student.getAge() + ",";
            str += student.getMathScore() + ",";
            str += student.getPhysicalScore() + ",";
            str += student.getChemistryScore() + ",";
            str += student.getAverageScore();
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }


    public static void main(String[] args) throws IOException {
        PersonService myPersonList = new PersonService();
        myPersonList.add(new Student("Hoa", 20, 6, 4, 5));
        myPersonList.add(new Student("Lan", 21, 7, 4, 5));
        myPersonList.add(new Student("H????ng", 29, 8, 6, 1));
        myPersonList.add(new Student("Th???y", 28, 10, 7, 9));
        myPersonList.add(new Student("H?????ng", 27, 5, 8, 8));
        myPersonList.add(new Student("Lan", 22, 4, 9, 10));
        myPersonList.add(new Student("Anh", 25, 3, 10, 5));
        myPersonList.add(new Student("Chi t???", 20, 6, 8, 7));

        FileReader fileReader = new FileReader("src/person_211027/menu/studentList.csv");
        ArrayList<Person> studentList1 = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = bufferedReader.readLine();
        while ((content = bufferedReader.readLine()) != null) {
            String[] array = content.split(",");
            String name = array[0];
            int age = Integer.parseInt(array[2]);
            double mathScore = Double.parseDouble(array[3]);
            double physicalScore = Double.parseDouble(array[4]);
            double chemistry = Double.parseDouble(array[5]);
            studentList1.add(new Student(name, age, mathScore, physicalScore, chemistry));
        }

        for (int i = 0; i < studentList1.size(); i++) {
            System.out.println(studentList1.get(i));
        }
    }
}

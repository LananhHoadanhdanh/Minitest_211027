package person_211027.service;

import person_211027.model.Person;

import java.util.ArrayList;

public class PersonService implements GeneralService<Person>{
    private ArrayList<Person> personList;

    public PersonService() {
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    @Override
    public void print() {
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        System.out.println("___________________________");
    }

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getPersonalId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void deleteById(int id) {
        if (findIndexById(id) != -1) {
            personList.remove(findIndexById(id));
        } else {
            System.err.println("Không tìm thấy!!!.");
        }
    }

    @Override
    public void editById(int id, Person person) {
        if (findIndexById(id) != -1) {
            personList.set(findIndexById(id), person);
        } else {
            System.err.println("Không tìm thấy!.");
        }
    }

    @Override
    public void findByName(String name) {
        boolean check = false;
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                System.out.println(person);
                check = true;
            }
        }
        if (!check) {
            System.err.println("Không có tên này!!!");
        }
    }
}

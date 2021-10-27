package person_211027.model;

public class Person {
    private int count;
    private String name;
    private int personalId;
    private int age;

    public Person() {
        count++;
    }

    public Person(String name, int age) {
        count++;
        personalId = count;
        this.name = name;
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

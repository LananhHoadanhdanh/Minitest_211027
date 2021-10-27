package person_211027.service;

public interface GeneralService<T> {
    void print();
    void add(T t);
    int findIndexById(int id);
    void deleteById(int id);
    void editById(int id, T t);
    void findByName(String name);
}

package travelAgency.service;

import java.util.List;

public interface CommonService<T> {

    T getById(long id);
    List<T> getAll();
    void add(T t);
    void update(long id, String... args);
    void delete(long id);
}

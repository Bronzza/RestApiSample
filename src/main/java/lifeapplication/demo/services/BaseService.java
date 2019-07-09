package lifeapplication.demo.services;

import java.util.List;

public interface BaseService<T> {
    List<T> getAll();

    T getByName(String name);

    T getById(Long id);

    void save(T user);
}

package web.repos;

import web.model.User;

import java.util.List;

public interface UserRepositoryInterface {
    void create(User user);
    void update(User user);
    void delete(User user);
    User findById(Integer id);
    List<User> findAll();
}

package web.repos;

import web.model.User;

import java.util.List;

public interface UserRepositoryInterface {
    void create(User user);
    void updateUser(User user);
    void delete(User user);
    User findById(Integer id);
    List<User> findAll();
}

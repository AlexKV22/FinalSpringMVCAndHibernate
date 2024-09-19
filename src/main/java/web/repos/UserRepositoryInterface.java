package web.repos;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositoryInterface {
    void create(User user);
    void updateUser(User user);
    void delete(User user);
    User findById(Integer id);
    List<User> findAll();
}

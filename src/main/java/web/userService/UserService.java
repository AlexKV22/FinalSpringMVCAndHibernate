package web.userService;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserById(Integer id);

    List<User> getAllUsers();
}

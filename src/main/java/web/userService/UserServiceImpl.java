package web.userService;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.repos.UserRepositoryInterface;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepositoryInterface userRepository;

    public UserServiceImpl(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.create(user);
    }

    @Override
    @Transactional
    public void updateUser(Integer id, User user) {
        User byId = userRepository.findById(id);
        byId.setName(user.getName());
        byId.setAge(user.getAge());
        userRepository.updateUser(byId);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

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
        userRepository.save(user);
    }

    @Override
    public void updateUser(Integer id, User user) {
//        User byId = userRepository.findById(Long.valueOf(id)).orElse(null);
//        if (byId != null) {
//            byId.setName(user.getName());
//            byId.setAge(user.getAge());
//        }
        userRepository.updateUserById(user.getName(), user.getAge(), id);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

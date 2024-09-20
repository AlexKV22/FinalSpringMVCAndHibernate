package web.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User set name = ?1, age =?2 where id = ?3")
    void updateUserById(String name, Integer age, Integer id);
//    void create(User user);
//    void updateUser(User user);
//    void deleteUser(User user);
//    User findUserById(Integer id);
//    List<User> findAllUsers();
}

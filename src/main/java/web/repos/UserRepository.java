package web.repos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import web.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public class UserRepository {

//    @PersistenceContext()
//    private EntityManager em;
//
//    @Override
//    public void create(User user) {
//        em.persist(user);
//    }
//
//    @Override
//    public void updateUser(User user) {
//        em.merge(user);
//    }
//
//    @Override
//    public void delete(User user) {
//        em.remove(user);
//    }
//
//    @Override
//    public User findById(Integer id) {
//        TypedQuery<User> query = em.createQuery("FROM User WHERE id = :id", User.class);
//        query.setParameter("id", id);
//        return query.getSingleResult();
//    }
//
//    @Override
//    public List<User> findAll() {
//        return em.createQuery("FROM User", User.class).getResultList();
//    }

}

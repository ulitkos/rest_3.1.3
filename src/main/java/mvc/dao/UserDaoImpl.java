package mvc.dao;

import org.springframework.stereotype.Repository;
import mvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUserById(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override

    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

//    @Override
//    public User getUserByName(String username) {
//        return entityManager.find(User.class, username);
//    }

    @Override
    public User getUserByName(String username) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username=:username",
                User.class).setParameter("username", username);
        return query.getSingleResult();
    }

}

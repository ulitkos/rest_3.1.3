package mvc.dao;

import mvc.model.User;
import org.springframework.stereotype.Repository;

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
    //@Query("select u from User u left join fetch u.roles")
    public List<User> getAllUsers() {
        //return entityManager.createQuery("from User", User.class).getResultList();
        return entityManager.createQuery("select distinct u from User u left join fetch u.roles", User.class).getResultList();
    }


    @Override
    public User getUserByName(String username) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u left join fetch u.roles where u.username=:username",
                User.class).setParameter("username", username);
        return query.getSingleResult();
    }

}

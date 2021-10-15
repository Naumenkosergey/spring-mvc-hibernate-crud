package org.example.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.example.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@AllArgsConstructor
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.id= :id", User.class);
        query.setParameter("id", id);
        return query.getResultStream().findAny().orElse(null);
    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
}

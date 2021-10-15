package org.example.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.example.model.User;
import org.example.model.UserTestNoDB;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@AllArgsConstructor
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return UserTestNoDB.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void removeUser(Long id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void addUser(User user) {

    }
}

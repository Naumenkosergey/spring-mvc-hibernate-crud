package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();

    User getUserById(Long id);

    void removeUser(Long id);

    void updateUser(User user);

    void addUser(User user);
}

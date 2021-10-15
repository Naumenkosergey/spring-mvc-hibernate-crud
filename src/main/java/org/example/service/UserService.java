package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User getByIdUser(Long id);

    void removeUser(Long id);

    void updateUser(User user);

    void addUser(User user);

}

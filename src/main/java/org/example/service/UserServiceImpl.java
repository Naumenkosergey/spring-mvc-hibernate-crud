package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional()
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}

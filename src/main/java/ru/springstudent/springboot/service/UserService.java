package ru.springstudent.springboot.service;

import ru.springstudent.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> showAllUsers();

    void addNewUser(User saveUser);

    void updateUser(User updateUser);

    void deleteUser(long id);

    User findById(long id);
}

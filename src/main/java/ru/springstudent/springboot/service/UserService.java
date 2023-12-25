package ru.springstudent.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springstudent.springboot.model.User;
import ru.springstudent.springboot.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void addNewUser(User saveUser) {
        userRepository.save(saveUser);
    }

    @Transactional
    public void updateUser(User updateUser) {
        userRepository.save(updateUser);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}

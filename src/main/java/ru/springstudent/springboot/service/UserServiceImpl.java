package ru.springstudent.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springstudent.springboot.model.User;
import ru.springstudent.springboot.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void addNewUser(User saveUser) {
        userRepository.save(saveUser);
    }

    @Transactional
    @Override
    public void updateUser(User updateUser) {
        userRepository.save(updateUser);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}

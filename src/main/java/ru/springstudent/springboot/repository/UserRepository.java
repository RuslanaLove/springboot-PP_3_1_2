package ru.springstudent.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springstudent.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

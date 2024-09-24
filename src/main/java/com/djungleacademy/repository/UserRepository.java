package com.djungleacademy.repository;

import com.djungleacademy.entity.User;
import com.djungleacademy.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Optional<User> findByUserName(String userName);
    List<User> findByUserType(UserType userType);
}

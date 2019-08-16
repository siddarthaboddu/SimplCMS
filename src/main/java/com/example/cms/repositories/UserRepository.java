package com.example.cms.repositories;

import com.example.cms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByEmail(String email);

    public User findUserByUsername(String username);
}

package com.authservernew.authservernew.repository;

import com.authservernew.authservernew.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String name);



}

package com.guchi.simpleWebApp.repository;

import com.guchi.simpleWebApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}




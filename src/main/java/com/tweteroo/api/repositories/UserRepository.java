package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tweteroo.api.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    public List <Users> findByUsername(String username);
}

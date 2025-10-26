package com.example.showmate.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.showmate.model.MovieUser;

@Repository
public interface MovieUserRepository extends JpaRepository<MovieUser, Long> {

    // Find a user by email
    MovieUser findByEmail(String email);

    // Find a user by username
    MovieUser findByUsername(String username);
}

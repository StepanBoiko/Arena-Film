package com.company.ArenaFilm.repos;

import com.company.ArenaFilm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

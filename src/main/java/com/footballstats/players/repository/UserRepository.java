
package com.footballstats.players.repository;

import com.footballstats.players.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}

package com.hp.main.reposetry;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hp.main.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    
    
}

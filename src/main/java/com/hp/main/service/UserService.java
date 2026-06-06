package com.hp.main.service;

import java.util.List;
import com.hp.main.model.User;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
    boolean emailExists(String email);
    User findByEmail(String email);  // ← yeh add karo
}
package com.reonfernandes.Smart_Connect.service;

import com.reonfernandes.Smart_Connect.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    User saveUser(User user);
    void deleteUser(Integer id);

    List<User> getUsers();
    List<User> getUsersByGender(String gender);
    List<User> getUsersByRegion(String region);
    List<User> getUsersByRole(String role);

    Optional<User> getUserById(Integer id);
    Optional<User> getUserByEmail(String email);
    Optional<User> updateUser(User user);
    boolean isUserExistByEmail(String email);
}
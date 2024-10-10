package com.reonfernandes.Smart_Connect.repository;

import com.reonfernandes.Smart_Connect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByGender(String gender);

    List<User> findByRegion(String region);

    List<User> findByRole(String role);

    Optional<User> findByEmail(String email);
}

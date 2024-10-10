package com.reonfernandes.Smart_Connect.service.implement;

import com.reonfernandes.Smart_Connect.exception.ResourceNotFound;
import com.reonfernandes.Smart_Connect.model.User;
import com.reonfernandes.Smart_Connect.repository.UserRepository;
import com.reonfernandes.Smart_Connect.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        logger.info("User saved with ID: {}", savedUser.getId());
        return savedUser;
    }

    @Override
    public void deleteUser(Integer id) {
        User deleteUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("User with id:" + id + " not found"));
        userRepository.delete(deleteUser);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByGender(String gender) {
        return userRepository.findByGender(gender);
    }

    @Override
    public List<User> getUsersByRegion(String region) {
        return userRepository.findByRegion(region);
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User newUser = userRepository.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFound("User with id:"+ user.getId()+" not found"));
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setGender(user.getGender());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setRegion(user.getRegion());
        newUser.setRole(user.getRole());
        newUser.setAddress(user.getAddress());

        newUser.setProfilePic(user.getProfilePic());

        newUser.setAccountEnabled(user.isAccountEnabled());
        newUser.setEmailVerified(user.isEmailVerified());
        newUser.setPhoneNumberVerified(user.isPhoneNumberVerified());

        newUser.setProviders(user.getProviders());
        newUser.setProviderId(user.getProviderId());

        User saveUser = userRepository.save(newUser);
        return Optional.ofNullable(saveUser);
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User userEmail = userRepository.findByEmail(email).orElse(null);
        return userEmail != null;
    }
}

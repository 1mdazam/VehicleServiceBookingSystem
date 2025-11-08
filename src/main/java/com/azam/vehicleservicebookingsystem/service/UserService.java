package com.azam.vehicleservicebookingsystem.service;

import com.azam.vehicleservicebookingsystem.entity.User;
import com.azam.vehicleservicebookingsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User validateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    public User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
}


}

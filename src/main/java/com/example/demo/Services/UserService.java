package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.UserRepo;
import com.example.demo.entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    public boolean updateUser(User user, long userId) {
        Optional<User> userOptional = userRepo.findById(userId);

        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setIdUser(user.getIdUser());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userRepo.save(userToUpdate);
            return true;
        } else {
            return false;
        }
    }
}

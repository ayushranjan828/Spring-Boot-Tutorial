package com.example.loggerapi.Project_Logger_API.Service;

import com.example.loggerapi.Project_Logger_API.Model.User;
import com.example.loggerapi.Project_Logger_API.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService 
{
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) 
    {
        logger.info("Saving user: {}", user.getEmail());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() 
    {
        logger.info("Fetching all users.");
        return userRepository.findAll();
    }

    public User getUserById(Long id) 
    {
        logger.info("Fetching user with ID: {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("User not found with ID: {}", id);
                    return new RuntimeException("User not found with ID: " + id);
                });
    }

    public void deleteUser(Long id) 
    {
        logger.info("Deleting user with ID: {}", id);
        if (userRepository.existsById(id)) 
        {
            userRepository.deleteById(id);
            logger.info("User with ID {} deleted successfully.", id);
        } 
        else 
        {
            logger.warn("Attempted to delete non-existent user with ID: {}", id);
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}

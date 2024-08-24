package com.zoulaika.User_Management_API.service;

import com.zoulaika.User_Management_API.exception.UserExistException;
import com.zoulaika.User_Management_API.exception.UserNotFoundException;
import com.zoulaika.User_Management_API.model.User;
import com.zoulaika.User_Management_API.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(User user, String userID) {
        // checks if a user with the given ID already exists
        if (userRepository.existsById(userID)) {
            throw new UserExistException(String.format("User with ID %s already exists.", userID));
        }

        // save the new user if they do not exist
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user, String userID) {
        // check if the user exists
        if (!userRepository.existsById(userID)) {
            throw new UserNotFoundException(String.format("User with ID %s not found for update.", userID));

        }
        // ensures the user object has the correct ID to update
        user.setUserID(userID);
        // save the updated user
        userRepository.save(user);

    }

    @Override
    public void deleteUser(String userID) {
        // checks if the user exists33
        if (!userRepository.existsById(userID)) {
            throw new UserNotFoundException(String.format("User with ID %s not found for deletion.", userID));
        }
        // proceed with deletion if the user exists
        userRepository.deleteById(userID);
    }

    @Override
    public User getUser(String userID) {
        // retrieves user from repository
        return userRepository.findById(userID)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with ID %s not found.", userID)));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
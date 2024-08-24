package com.zoulaika.User_Management_API.controller;

import com.zoulaika.User_Management_API.exception.ErrorResponse;
import com.zoulaika.User_Management_API.exception.UserExistException;
import com.zoulaika.User_Management_API.exception.UserNotFoundException;
import com.zoulaika.User_Management_API.model.User;
import com.zoulaika.User_Management_API.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/User")
public class UserController {

    private final UserService userService;
    private final ErrorResponse errorResponse;

    // Gets a specific user with their ID
    @GetMapping("/{userID}")
    public ResponseEntity<?> getUser(@PathVariable("userID") String userID) {
        User user = userService.getUser(userID);
        if (user == null) {
           //returns http status Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        //returns success message
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    // Gets all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // creates a new user
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            // extracts userID from the user object
            String userID = user.getUserID();

            // calls service method to create user
            userService.createUser(user, userID);

            // Return success response
            return ResponseEntity.status(HttpStatus.CREATED).body("User has been created successfully");
        } catch (UserExistException e) {
            // handles the case where user already exists
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            // handles other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the user");
        }
    }

    // updates user information
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            // Extracts userID from the user object
            String userID = user.getUserID();
            // Calls service method to update user
            userService.updateUser(user, userID);
            // Returns success response
            return ResponseEntity.status(HttpStatus.OK).body("User has been updated successfully");
        } catch (UserNotFoundException e) {
            // Handles the case where the user does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            // Handles other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the user");
        }
    }

    // deletes a specific user with their ID
    @DeleteMapping("/{userID}")
    public ResponseEntity<String> deleteUser(@PathVariable("userID") String userID) {
        try {
            // call service method to delete the user
            userService.deleteUser(userID);
            // return no content response if successful
            return ResponseEntity.status(HttpStatus.OK).body("User Has Been Successfully Deleted");
        } catch (UserNotFoundException e) {
            // handle the case where the user does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            // handle other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the user");
        }
    }
}

package com.zoulaika.User_Management_API.service;

import com.zoulaika.User_Management_API.model.User;

import java.util.List;

//service interface
public interface UserService {
    public void createUser(User user, String userID);
    public void updateUser (User user, String userID);
    public void deleteUser (String userID);
    public User getUser (String userID);
    public List<User> getAllUsers();
}

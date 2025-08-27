package com.fooddelivery.service;

import com.fooddelivery.dao.UserDAO;
import com.fooddelivery.model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    // Register new user
    public void registerUser(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        userDAO.saveUser(user);
    }

    // Get user by ID
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // Update user info
    public void updateUser(int id, String name, String email, String password) {
        User user = userDAO.getUserById(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            userDAO.updateUser(user);
        } else {
            System.out.println("User not found with ID: " + id);
        }
    }

    // Delete user
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    // Simple login check
    public User login(String email, String password) {
        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u; // Login successful
            }
        }
        return null; // Login failed
    }
}

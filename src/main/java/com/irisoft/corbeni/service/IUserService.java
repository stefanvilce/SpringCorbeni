package com.irisoft.corbeni.service;

import java.util.List;
import com.irisoft.corbeni.model.User;

public interface IUserService {
	List<User> getAllUsers();
    User getUserById(int id);
    User getUserByName(String username);
    boolean addUser(User user);
    void deleteUser(int id);
    boolean userExists(String username, String password);
}
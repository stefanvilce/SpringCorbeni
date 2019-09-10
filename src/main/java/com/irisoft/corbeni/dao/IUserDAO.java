package com.irisoft.corbeni.dao;

import java.util.List;
import com.irisoft.corbeni.model.User;

public interface IUserDAO {
	List<User> getAllUsers();
	User getUserByName(String username);
    User getUserById(int id);
    void addUser(User user);
    void deleteUser(int id);
    boolean userExists(String username, String password);
}

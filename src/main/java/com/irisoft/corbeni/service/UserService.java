package com.irisoft.corbeni.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irisoft.corbeni.dao.IUserDAO;
import com.irisoft.corbeni.model.User;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDAO userDAO;
		
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public User getUserById(int id) {
		User obj = userDAO.getUserById(id);
		return obj;
	}
	
	@Override
	public User getUserByName(String username) {
		User obj = userDAO.getUserByName(username);
		return obj;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username, String password) {
		boolean existsOrNot = userDAO.userExists(username, password);
		return existsOrNot;
	}	
}

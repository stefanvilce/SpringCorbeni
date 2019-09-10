package com.irisoft.corbeni.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.irisoft.corbeni.model.User;
import com.irisoft.corbeni.model.UserRowMapper;


@Transactional
@Repository
public class UserDAO implements IUserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM users";
		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	@Override
	public User getUserByName(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, username);
		return user;
	}
	@Override
	public User getUserById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return user;
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean userExists(String username, String password) {
		String sql = "SELECT count(*) FROM users WHERE username = ? AND password = SHA1(?)";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
}

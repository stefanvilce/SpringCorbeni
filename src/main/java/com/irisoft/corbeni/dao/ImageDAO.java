package com.irisoft.corbeni.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.irisoft.corbeni.model.Image;
import com.irisoft.corbeni.model.ImageRowMapper;


@Transactional
@Repository
public class ImageDAO implements IImageDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Image> getAllImages(int pagesId) {
		String sql = "SELECT images.* FROM images WHERE pagesId = ? ";
		RowMapper<Image> rowMapper = new ImageRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, pagesId);
	}
	@Override
	public Image getImagePrincipal(int pagesId) {
		String sql = "SELECT * FROM images WHERE pagesId = ? AND principala LIKE 'Yes'";
		RowMapper<Image> rowMapper = new BeanPropertyRowMapper<Image>(Image.class);
		Image image = jdbcTemplate.queryForObject(sql, rowMapper, pagesId);
		return image;
	}
	@Override
	public Image getImageById(int id) {
		String sql = "SELECT * FROM images WHERE id = ? ";
		RowMapper<Image> rowMapper = new BeanPropertyRowMapper<Image>(Image.class);
		Image image = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return image;
	}
	@Override
	public void addImage(Image image) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteImage(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean imageExists(int id, int pagesId) {
		// TODO Auto-generated method stub
		return false;
	}	
}

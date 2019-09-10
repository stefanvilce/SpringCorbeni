package com.irisoft.corbeni.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ImageRowMapper implements RowMapper<Image> {

	@Override
	public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
		Image image = new Image();
		image.setId(rs.getInt("id"));
		image.setImagName(rs.getString("imagName"));
		image.setUrl(rs.getString("url"));
		image.setPagesId(rs.getInt("pagesId"));
		image.setPrincipala(rs.getString("principala"));
		return image;
	}

}

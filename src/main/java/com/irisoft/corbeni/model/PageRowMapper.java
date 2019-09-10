package com.irisoft.corbeni.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PageRowMapper implements RowMapper<Page> {

	@Override
	public Page mapRow(ResultSet row, int rowNum) throws SQLException {
		Page page = new Page();
		page.setId(row.getInt("id"));
		page.setTitle(row.getString("title"));
		page.setSubtitle(row.getString("subtitle"));
		page.setLink(row.getString("link"));
		page.setShortDescription(row.getString("shortDescription"));
		page.setContent(row.getString("content"));
		page.setLang(row.getString("lang"));
		page.setPublished(row.getString("published"));
		page.setPublishedAt(row.getString("publishedAt"));
		page.setModifiedAt(row.getString("modifiedAt"));
		page.setCategory(row.getString("category"));
		return page;
	}	

}

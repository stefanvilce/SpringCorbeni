package com.irisoft.corbeni.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.irisoft.corbeni.model.Page;
import com.irisoft.corbeni.model.PageRowMapper;


@Transactional
@Repository
public class PageDAO implements IPageDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Page getPageById(int id, String lang) {
		String sql = "SELECT pages.id, pagescontent.pagesId, pagescontent.title, pagescontent.subtitle, pagescontent.shortDescription, pagescontent.content, pagescontent.lang, "
				+ "				pagescontent.category, pagescontent.published, pagescontent.publishedAt, pagescontent.modifiedAt "
				+ "				FROM pages, pagescontent "
				+ "				WHERE pages.id=pagescontent.pagesId AND pages.id=? AND pagescontent.lang=? "; //aici nu intreb daca e si publicata, 
		//																										pentru ca aceasta interogare o sa o folosesc in administrare, 
		//																										unde trebuie sa pot sa ii dau Publish sau Unpublish
		
		RowMapper<Page> rowMapper = new BeanPropertyRowMapper<Page>(Page.class);
		Page page = jdbcTemplate.queryForObject(sql, rowMapper, id, lang);
		return page;
	}
	@Override
	public List<Page> getAllPages() {
		String sql = "SELECT pages.id, pagescontent.title, pagescontent.subtitle, pagescontent.link, "
				+ "				pagescontent.shortDescription, pagescontent.content, pagescontent.lang, "
				+ "				pagescontent.category, pagescontent.published, pagescontent.publishedAt, pagescontent.modifiedAt "
				+ "				FROM pages, pagescontent "
				+ "				WHERE pages.id=pagescontent.pagesId AND pagescontent.published LIKE 'Yes' ORDER BY id DESC"; //trebuie sa introduc si limba aici
		RowMapper<Page> rowMapper = new PageRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	@Override
	public Page getPageByLink(String link, String lang) {
		String sql = "SELECT pages.id, pagescontent.pagesId, pagescontent.title, pagescontent.subtitle, pagescontent.shortDescription, pagescontent.content, pagescontent.lang, "
				+ "				pagescontent.category, pagescontent.published, pagescontent.publishedAt, pagescontent.modifiedAt "
				+ "				FROM pages, pagescontent "
				+ "				WHERE pages.id=pagescontent.pagesId AND pagescontent.link=? AND pagescontent.lang=? AND pagescontent.published LIKE 'Yes'";
		RowMapper<Page> rowMapper = new BeanPropertyRowMapper<Page>(Page.class);
		Page page = jdbcTemplate.queryForObject(sql, rowMapper, link, lang);
		return page;
	}
	@Override
	public void addPage(Page page) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updatePage(Page page) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deletePage(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean pageExists(int id, String lang) {
		// TODO Auto-generated method stub
		return false;
	}	
}

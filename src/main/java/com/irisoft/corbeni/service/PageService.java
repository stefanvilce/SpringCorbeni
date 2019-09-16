package com.irisoft.corbeni.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irisoft.corbeni.dao.IPageDAO;
import com.irisoft.corbeni.model.Page;

@Service
public class PageService implements IPageService {
	@Autowired
	private IPageDAO pageDAO;
	@Override
	public List<Page> getAllPages() {
		return pageDAO.getAllPages();
	}

	@Override
	public Page getPageById(int id, String lang) {
		Page obj = pageDAO.getPageById(id, lang);
		return obj;
	}
	
	@Override
	public Page getPageByLink(String link, String lang) {
		Page obj = pageDAO.getPageByLink(link, lang);
		return obj;
	}

	@Override
	public boolean addPage(Page page) {
		// TODO Auto-generated method stub
		return false;
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
	public Page getPageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

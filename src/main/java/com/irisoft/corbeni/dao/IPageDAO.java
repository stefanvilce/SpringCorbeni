package com.irisoft.corbeni.dao;

import java.util.List;
import com.irisoft.corbeni.model.Page;

public interface IPageDAO {
	List<Page> getAllPages();
	Page getPageByLink(String link, String lang);
    Page getPageById(int id, String lang);
    void addPage(Page page);
    void updatePage(Page page);
    void deletePage(int id);
    boolean pageExists(int id, String lang);	
}

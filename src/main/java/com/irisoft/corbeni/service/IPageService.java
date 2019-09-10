package com.irisoft.corbeni.service;

import java.util.List;
import com.irisoft.corbeni.model.Page;

public interface IPageService {
	List<Page> getAllPages();
    Page getPageById(int id);
    boolean addPage(Page page);
    void updatePage(Page page);
    void deletePage(int id);
	Page getPageById(int id, String lang);
	Page getPageByLink(String link, String lang);
}
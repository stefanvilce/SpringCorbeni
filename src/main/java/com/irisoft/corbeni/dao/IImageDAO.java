package com.irisoft.corbeni.dao;

import java.util.List;
import com.irisoft.corbeni.model.Image;

public interface IImageDAO {
	List<Image> getAllImages(int pagesId);
	Image getImagePrincipal(int pagesId);
    Image getImageById(int id);
    void addImage(Image image);
    void deleteImage(int id);
    boolean imageExists(int id, int pagesId);	
}

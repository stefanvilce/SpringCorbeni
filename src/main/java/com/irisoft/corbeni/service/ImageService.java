package com.irisoft.corbeni.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irisoft.corbeni.dao.IImageDAO;
import com.irisoft.corbeni.model.Image;

@Service
public class ImageService implements IImageService {
	@Autowired
	private IImageDAO imageDAO;
		
	@Override
	public List<Image> getAllImages(int pagesId) {
		return imageDAO.getAllImages(pagesId);
	}

	@Override
	public Image getImageById(int id) {
		Image obj = imageDAO.getImageById(id);
		return obj;
	}

	@Override
	public Image getImagePrincipal(int pagesId) {
		Image obj = imageDAO.getImagePrincipal(pagesId);
		return obj;
	}

	@Override
	public boolean addImage(Image image) {
		// TODO Auto-generated method stub
		return false;
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

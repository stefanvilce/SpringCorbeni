package com.irisoft.corbeni.service;

import java.util.List;
import com.irisoft.corbeni.model.Image;

public interface IImageService {
	List<Image> getAllImages(int pagesId);
    Image getImageById(int id);
    Image getImagePrincipal(int pagesId);
    boolean addImage(Image image);
    void deleteImage(int id);
    boolean imageExists(int id, int pagesId);
}
package com.irisoft.corbeni.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.irisoft.corbeni.model.Image;
import com.irisoft.corbeni.service.IImageService;

@SuppressWarnings("unused")
@Controller
@RequestMapping
public class ImageController {
	@Autowired
	private IImageService imageService;
	@GetMapping("image/{id}")
	public ResponseEntity<Image> getImageById(@PathVariable("id") Integer id) {
		Image image = imageService.getImageById(id);
		return new ResponseEntity<Image>(image, HttpStatus.OK);
	}
	@GetMapping("imagePrincipal/{pagesId}")
	public ResponseEntity<Image> getImagePrincipal(@PathVariable("pagesId") int pagesId) {
		Image image = imageService.getImagePrincipal(pagesId);
		return new ResponseEntity<Image>(image, HttpStatus.OK);
	}
	@GetMapping("images/{pagesId}")
	public ResponseEntity<List<Image>> getAllImages(@PathVariable("pagesId") int pagesId) {
		List<Image> list = imageService.getAllImages(pagesId);
		return new ResponseEntity<List<Image>>(list, HttpStatus.OK);
	}
/*	@PostMapping("article")
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
                boolean flag = articleService.addArticle(article);
                if (flag == false) {
        	   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}*/
}

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
import com.irisoft.corbeni.model.Page;
import com.irisoft.corbeni.service.IPageService;

@SuppressWarnings("unused")
@Controller
@RequestMapping
public class PageController {
	@Autowired
	private IPageService pageService;
	@GetMapping("page/{id}/{lang}")
	public ResponseEntity<Page> getPageById(@PathVariable("id") Integer id, @PathVariable("lang") String lang) {
		Page page = pageService.getPageById(id, lang);
		return new ResponseEntity<Page>(page, HttpStatus.OK);
	}
	@GetMapping("pagelink/{link}/{lang}")
	public ResponseEntity<Page> getPageByLink(@PathVariable("link") String link, @PathVariable("lang") String lang) {
		Page page = pageService.getPageByLink(link, lang);
		return new ResponseEntity<Page>(page, HttpStatus.OK);
	}
	@GetMapping("pages")
	public ResponseEntity<List<Page>> getAllPages() {
		List<Page> list = pageService.getAllPages();
		return new ResponseEntity<List<Page>>(list, HttpStatus.OK);
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

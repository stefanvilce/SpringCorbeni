package com.irisoft.corbeni.controller;

import java.util.List;
import com.irisoft.corbeni.model.Page;
import com.irisoft.corbeni.service.IPageService;

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
	@PostMapping("page")
	public ResponseEntity<Void> addPage(@RequestBody Page page, UriComponentsBuilder builder) {
                boolean flag = pageService.addArticle(page);
                if (flag == false) {
        	   		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/page/{id}/{lang}").buildAndExpand(article.getPageId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("page")
	public ResponseEntity<Page> updatePage(@RequestBody Page page) {
		pageService.updatePage(page);
		return new ResponseEntity<Page>(page, HttpStatus.OK);
	}
	@DeleteMapping("page/{id}")
	public ResponseEntity<Void> deletePage(@PathVariable("id") Integer id) {
		pageService.deletePage(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

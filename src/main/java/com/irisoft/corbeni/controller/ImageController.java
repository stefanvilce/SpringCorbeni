package com.irisoft.corbeni.controller;

import java.util.List;
import com.irisoft.corbeni.model.Image;
import com.irisoft.corbeni.service.IImageService;

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
}

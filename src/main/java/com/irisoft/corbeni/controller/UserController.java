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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import com.irisoft.corbeni.model.User;
import com.irisoft.corbeni.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@SuppressWarnings("unused")
@Controller
@RequestMapping
public class UserController {
	@Autowired
	private IUserService userService;
	@GetMapping("user/{id}") // Aceste linkuri nu ar trebui sa fie accesibile
							// Le pun aici doar ca sa am ghidare
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping("userbyname/{username}")
	public ResponseEntity<User> getUserByName(@PathVariable("username") String username) {
		User user = userService.getUserByName(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	@RequestMapping(value = "userlogin", method = RequestMethod.POST)
	public ResponseEntity<User> userExists(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
                boolean flag = userService.userExists(username, password);
                if (flag == false) {
                	return new ResponseEntity<User>(HttpStatus.CONFLICT);
                }
                User user = userService.getUserByName(username);                
                String userSession = (String) session.getAttribute("userSession");
        		if(userSession == null) {
        			if(user.getActiv() == 1) {
        				session.setAttribute("userSession", "loggedin");
        				session.setAttribute("username", username);
        			}
        		}        		
                return new ResponseEntity<User>(user, HttpStatus.OK);                
	}
	
	//trebuie sa fac si logout-ul aici. Dar maine
	
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

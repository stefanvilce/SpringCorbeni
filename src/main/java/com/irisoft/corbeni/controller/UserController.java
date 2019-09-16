package com.irisoft.corbeni.controller;

import java.util.List;
import com.irisoft.corbeni.model.User;
import com.irisoft.corbeni.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class UserController {
	@Autowired
	private IUserService userService;
	@GetMapping("user/{id}")
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
}
package com.irisoft.corbeni.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.irisoft.corbeni.controller.Helpers;
import com.irisoft.corbeni.model.User;
import com.irisoft.corbeni.service.IUserService;

@Controller
@RequestMapping("admin")
public class AdminIndexViewController {
	
	@Autowired
	private IUserService userService;

    @GetMapping("/")
    public String adminLogin(HttpSession session, Model model) {
        model.addAttribute("titleUpHome", "My next holiday");
        model.addAttribute("subtitleUpHome", "Here I would like travel soon. As soon as possible");
        model.addAttribute("userSession", session.getAttribute("userSession"));
		model.addAttribute("username", session.getAttribute("username"));
		if(session.getAttribute("userSession") != null) {
			return "redirect:/admin/pages";
		}
    	return "admin/index";
    }

    @PostMapping("/")
    public String adminLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
    	model.addAttribute("titleUpHome", "My next holiday");
        model.addAttribute("subtitleUpHome", "Here I would like travel soon. As soon as possible");
        model.addAttribute("Logat", "");
    	boolean flag = userService.userExists(username, password);
        if (flag == false) {
        	model.addAttribute("Logat", "Nu ne-am putut Autentifica");
        	return "admin/index"; //new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
        User user = userService.getUserByName(username);                
        String userSession = (String) session.getAttribute("userSession");
		if(userSession == null) {
			if(user.getActiv() == 1) {
				session.setAttribute("userSession", "loggedin");
				session.setAttribute("username", username);
			}
			model.addAttribute("Logat", "Autentificat ca ..... " + username);
			model.addAttribute("userSession", session.getAttribute("userSession"));
			model.addAttribute("username", session.getAttribute("username"));
			return "redirect:/admin/pages";
		}  
        return "admin/index";
    }
    
    @GetMapping("/logout")
    public String adminLogout(HttpSession session, Model model) {
    	model.addAttribute("titleUpHome", "My next holiday");
    	model.addAttribute("subtitleUpHome", "Here I would like travel soon. As soon as possible");
    	model.addAttribute("Logat", "....");        
    	session.removeAttribute("userSession");
    	session.removeAttribute("username");        
    	model.addAttribute("Logout", "Logging out");    	
    	return "redirect:/admin/";
    }
    

    @GetMapping("/pages")
    public String adminPages(HttpSession session, Model model) {
    	if(session.getAttribute("userSession") == null) {
    		return "redirect:/admin/";
    	}
    	model.addAttribute("titleUpHome", "CMS Corbeni");
    	model.addAttribute("subtitleUpHome", "Administration CMS");
    	model.addAttribute("title", "The list of pages");        
    	model.addAttribute("subtitle", "Corbeni");
    	model.addAttribute("shortDescription", "This is going to be the list with all pages which will be administrated here.");
    	model.addAttribute("content", "... soon ...");
    	model.addAttribute("userSession", session.getAttribute("userSession"));
		model.addAttribute("username", session.getAttribute("username"));
    	return "admin/admin_pages";
    }
}

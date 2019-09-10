package com.irisoft.corbeni;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Aceasta clasa este doar de test ca sa vad cum functioneaza SpringBoot
import org.springframework.web.client.RestTemplate;

import com.irisoft.corbeni.controller.Helpers;
import com.irisoft.corbeni.model.Page;

@RestController
public class Pagina {
	@RequestMapping("/pagina/")
	public String pagina() {
		String p = "<html><head><title></title></head><body>";
		p = p + "<h2>Test de pagina</h2><p>Testare existenta pagina .... </p>";
		p = p + "</body></html>";
        	return p;
	}
	
	@RequestMapping("/articles")
	public String paginaDeTest(HttpSession session) {
		//partea aceasta cu 
		String language = (String) session.getAttribute("language");
		if(language == null) {
			session.setAttribute("language", "en");
		}
		
		String p = "<html><head><title>Testare pagina</title></head><body>";
		p = p + "<h2>oooohhhh . . . </h2><p>Toate paginile </p>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = Helpers.localServer + "/pages";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Page[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Page[].class);
        Page[] pages = responseEntity.getBody();
        for(Page page : pages) {
              p = p + "Id: "+page.getId()+", Title:"+page.getTitle()
                      +", Category: "+page.getCategory();
        }
        p = p + "</body></html>";
    	return p;
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	
}

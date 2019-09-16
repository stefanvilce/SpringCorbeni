package com.irisoft.corbeni;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.irisoft.corbeni.controller.Helpers;
import com.irisoft.corbeni.model.Image;
import com.irisoft.corbeni.model.Page;

@SuppressWarnings("unused")
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
    	
    	Page[] page = this.theLastPages();
        model.addAttribute("titleUpHome", "My next holiday");
        model.addAttribute("subtitleUpHome", "Here I would like travel soon. As soon as possible");
    	
        model.addAttribute("title", page[0].getTitle());
        model.addAttribute("subtitle", page[0].getSubtitle());
        model.addAttribute("shortDescription", page[0].getShortDescription());
        model.addAttribute("link", page[0].getLink());
        model.addAttribute("pozaPrincipala", this.imagePrincipal(page[0].getId()));
        
        //Si acum iau si partea de jos
        model.addAttribute("subtitle1", page[1].getTitle());
        model.addAttribute("subsubtitle1", page[1].getSubtitle());
        model.addAttribute("link1", page[1].getLink());
        model.addAttribute("shortDescription1", page[1].getShortDescription());
        model.addAttribute("pozaPrincipala1", this.imagePrincipal(page[1].getId()));
        model.addAttribute("subtitle2", page[2].getTitle());
        model.addAttribute("subsubtitle2", page[2].getSubtitle());
        model.addAttribute("link2", page[2].getLink());
        model.addAttribute("shortDescription2", page[2].getShortDescription());
        model.addAttribute("pozaPrincipala2", this.imagePrincipal(page[2].getId()));
        return "index";
    }
    
    private Page[] theLastPages() {
    	//De fapt, ia toate paginile, dar eu arat doar trei pagini pe index
     	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
    	String url = Helpers.localServer + "/pages";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Page[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Page[].class);
        Page[] pages = responseEntity.getBody();
        return pages;
    }

    private String imagePrincipal(Integer pagesId){
    	HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = Helpers.localServer + "/imagePrincipal/" + pagesId.toString();
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Image> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Image.class, 1);
        Image image = responseEntity.getBody();   
        String imgsrc = "";
        imgsrc = image.getUrl() + image.getImagName();
        return imgsrc;
    }

}

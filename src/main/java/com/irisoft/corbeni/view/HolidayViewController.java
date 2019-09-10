package com.irisoft.corbeni.view;

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
import com.irisoft.corbeni.model.Page;

@Controller
public class HolidayViewController {

    @GetMapping("/article/{id}")	// calupul acesta nu trebuie sa mai fie aici, Este pus doar ca model. 
    public String holiday(@PathVariable("id") Integer id, Model model) throws IOException, UnsupportedEncodingException {
    	HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
    	String url = Helpers.localServer + "/page/" + id.toString() + "/en";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Page> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Page.class, 1);
        Page page = responseEntity.getBody();   
        model.addAttribute("titleUpHome", "My next holiday");
        model.addAttribute("subtitleUpHome", "Here I would like travel soon. As soon as possible");    	
        model.addAttribute("title", page.getTitle());
        model.addAttribute("subtitle", page.getSubtitle());
        model.addAttribute("shortDescription", page.getShortDescription());
        model.addAttribute("content", page.getContent());
        return "holiday";
    }
    
    @GetMapping("/holiday/{link}") 
    public String holiday(@PathVariable("link") String link, Model model) throws IOException, UnsupportedEncodingException {
    	HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
    	String url = Helpers.localServer + "/pagelink/" + link + "/en";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Page> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Page.class, 1);
        Page page = responseEntity.getBody();   
        model.addAttribute("titleUpHome", "My next holiday");
        model.addAttribute("subtitleUpHome", "Here I would like travel soon. As soon as possible");
        model.addAttribute("title", page.getTitle());
        model.addAttribute("subtitle", page.getSubtitle());
        model.addAttribute("shortDescription", page.getShortDescription());
        model.addAttribute("content", page.getContent());
        return "holiday";
    }

}

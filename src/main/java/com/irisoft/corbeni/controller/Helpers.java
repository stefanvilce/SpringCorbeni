package com.irisoft.corbeni.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * 	This class is only for some variables that I need across the project
 */
public class Helpers {
	public static String cookie = "en";
	public static String localServer = "http://localhost:8080";
	
	public List<String> Helpers(HttpSession session) {
		List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
		return messages;
	}
}

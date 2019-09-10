package com.irisoft.corbeni.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * 	This class which are doing  
 */
public class Helpers {
	public static String cookie = "en";
	public static String localServer = "http://localhost:8080";
	
	public Helpers(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
		System.out.println("Test " + " " + messages.get(1));

		//preiau sesiunile
		//HttpSession newSession = request.getSession(true);
	}
}

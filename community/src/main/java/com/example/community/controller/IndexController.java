package com.example.community.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.community.mapper.UserMapper;
import com.example.community.model.User;

@Controller
public class IndexController {
	
	@Autowired
	private UserMapper usermapper;

	@GetMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("token")) {
				String token = cookie.getValue();
				User user = usermapper.findByToken(token);
				if(user != null) {
					request.getSession().setAttribute("user", user);
				}
				break;
			}
		}
		
		return "index";
	}
	
}
